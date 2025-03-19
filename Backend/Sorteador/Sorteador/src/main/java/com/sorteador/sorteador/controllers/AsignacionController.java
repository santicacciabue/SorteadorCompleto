package com.sorteador.sorteador.controllers;


import com.sorteador.sorteador.exceptions.EntityNotFoundException;
import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.services.AsignacionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/asignacion")
public class AsignacionController {
    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping("/listar")
    public List<Asignacion> listarAsignacion(){
        return asignacionService.listarAsignaciones();
    }

    @GetMapping("/listar/{id}")
    public Object obtenerAsignacionId(@PathVariable int id, RedirectAttributes redirect) throws EntityNotFoundException {
        Optional<Asignacion> asignacionOptional = asignacionService.listarAsignacionId(id);
        if(asignacionOptional.isPresent()) {
            return asignacionService.listarAsignacionId(id);
        }else{
            redirect.addFlashAttribute("error", "La asignacion con id " +
                    id +
                    " no existe en la base de datos!");

            return "redirect:/api/asignacion";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Asignacion>agregarAsignacion(@RequestBody Asignacion asignacion) throws EntityNotFoundException{
        Asignacion nuevaAsignacion = asignacionService.agregarAsignacion(asignacion);
        return new ResponseEntity<>(nuevaAsignacion, HttpStatus.CREATED);
    }
    
    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarAsignacion(@PathVariable Integer id, @RequestBody Asignacion asignacionModificada) throws EntityNotFoundException{
        try {
            Asignacion asignacion = asignacionService.modificarAsignacion(id, asignacionModificada);
            return ResponseEntity.ok(asignacion);
            
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
       
    }

    // @GetMapping("/delete/{id}")
    // public String borrarAsignacion(@PathVariable int id, RedirectAttributes redirect){
    //     Optional<Asignacion> optionalAsignacion = asignacionService.listarAsignacionId(id);
    //     if(optionalAsignacion.isPresent()){
    //         redirect.addFlashAttribute("success", "La asignacion se ha eliminado con exito!");
    //         asignacionService.borrarAsignacion(id);
    //         return "redirect:/api/asignacion";
    //     }
    //     redirect.addFlashAttribute("error", "Error la asignacion no existe en el sistema");
    //     return "redirect:/api/asignacion";
    // }

}























