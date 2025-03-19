package com.sorteador.sorteador.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sorteador.sorteador.model.Integrante;
import com.sorteador.sorteador.services.GrupoService;
import com.sorteador.sorteador.services.IntegranteService;

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
@RequestMapping("/api/integrante")
public class IntegranteController {
    private final IntegranteService integranteService;

    public IntegranteController(IntegranteService integranteService, GrupoService grupoService) {
        this.integranteService = integranteService;
    }

    @GetMapping("/listar")
    public List<Integrante>listarIntegrantes() {
        return integranteService.listarIntegrantes();
    }
    
    @GetMapping("/listar/{id}")
    public Object listarIntegranteId(@PathVariable int id, RedirectAttributes redirect) {
        Optional<Integrante> integranteOptional = integranteService.listarIntegranteId(id);
        if(integranteOptional.isPresent()){
            return integranteService.listarIntegranteId(id);
        }else{
            redirect.addFlashAttribute("error", "El integrante no se encuentra en la base de datos!");
            return "redirect:/api/integrante";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Integrante>agregarIntegrante(@RequestBody Integrante integrante) {
        Integrante nuevoIntegrante = integranteService.agregarIntegrante(integrante);
        return new ResponseEntity<>(nuevoIntegrante,HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarIntegrante(@PathVariable Integer id, @RequestBody Integrante integranteModificado) {
        try {
            Integrante integrante = integranteService.modificarIntegrante(id,integranteModificado);
            return ResponseEntity.ok(integrante);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+ e.getMessage());
        }
    }

    @PutMapping("modificar/{id}/grupo/{grupoId}")
    public ResponseEntity<?> modificarGrupoIntegrante(@PathVariable int id, @PathVariable int grupoId) {
        integranteService.modificarGrupoIntegrante(id, grupoId);
        return ResponseEntity.ok(integranteService.listarIntegranteId(id));
    }
    

}
