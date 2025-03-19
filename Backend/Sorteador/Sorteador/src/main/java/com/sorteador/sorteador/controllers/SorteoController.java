package com.sorteador.sorteador.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sorteador.sorteador.model.Sorteo;
import com.sorteador.sorteador.services.SorteoService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/sorteo")
public class SorteoController {

    private final SorteoService sorteoService;

    public SorteoController(SorteoService sorteoService) {
        this.sorteoService = sorteoService;
    }

    @GetMapping("/listar")
    public List<Sorteo>listarSorteo() {
        return sorteoService.listarSorteos();
    }

    @GetMapping("/listar/{id}")
    public Object listarSorteoId(@PathVariable int id, RedirectAttributes redirect) {
        Optional<Sorteo> sorteoOptional = this.sorteoService.listarSorteoId(id);
        if(sorteoOptional.isPresent()){
            return sorteoService.listarSorteoId(id);
        }else{
            redirect.addFlashAttribute("error", "El sorteo no se encuentra en la base de datos!");
            return "redirect:/api/sorteo";
        }
    }


    @PostMapping("/agregar")
    public ResponseEntity<Sorteo> agregarSorteo(@RequestBody Sorteo sorteo) {
        Sorteo sorteoNuevo = this.sorteoService.agregarSorteo(sorteo);
        return new ResponseEntity<>(sorteoNuevo,HttpStatus.CREATED);
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<?> modificarSorteo(@PathVariable int id, @RequestBody Sorteo sorteoModificado) {
        try {
            Sorteo sorteo = sorteoService.modificarSorteo(id, sorteoModificado);
            return ResponseEntity.ok(sorteo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+ e.getMessage());
        }
    }
    
}
