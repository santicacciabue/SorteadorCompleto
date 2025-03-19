package com.sorteador.sorteador.controllers;


import com.sorteador.sorteador.model.Solicitud_reemplazo;
import com.sorteador.sorteador.services.Solicitud_reemplazoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/solicitud")
public class Solicitud_reemplazoController {
    private final Solicitud_reemplazoService solicitudReemplazoService;

    public Solicitud_reemplazoController(Solicitud_reemplazoService solicitudReemplazoService) {
        this.solicitudReemplazoService = solicitudReemplazoService;
    }

    @GetMapping("/listar")
    public List<Solicitud_reemplazo> listarSolicitudes(){
        return solicitudReemplazoService.listarSolicitudReemplazo();
    }

    @GetMapping("/listar/{id}")
    public Object obtenerSolicitudId(@PathVariable int id, RedirectAttributes redirect){
        Optional<Solicitud_reemplazo> solicitudOptional = solicitudReemplazoService.listarSolicitudReemplazoId(id);
        if(solicitudOptional.isPresent()){
            return solicitudReemplazoService.listarSolicitudReemplazoId(id);
        }else{
            redirect.addFlashAttribute("error", "La solicitud no se encuentra en la base de datos!");
            return "redirect:/api/solicitud";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Solicitud_reemplazo> agregarSolicitud(@RequestBody Solicitud_reemplazo solicitudReemplazo){
        Solicitud_reemplazo solicitudReemplazoNueva = solicitudReemplazoService.agregarSolicitudReemplazo(solicitudReemplazo);
        return new ResponseEntity<>(solicitudReemplazoNueva, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarSolicitud(@PathVariable int id, @RequestBody Solicitud_reemplazo solicitudReemplazoMod){
        try{
            Solicitud_reemplazo solicitud_reemplazo = solicitudReemplazoService.modificarSolicitudReemplazo(id, solicitudReemplazoMod);
            return ResponseEntity.ok(solicitud_reemplazo);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+e.getMessage());
        }
    }





}
