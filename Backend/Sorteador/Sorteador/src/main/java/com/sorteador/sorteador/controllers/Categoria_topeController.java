package com.sorteador.sorteador.controllers;


import com.sorteador.sorteador.model.Categoria_tope;
import com.sorteador.sorteador.services.Categoria_topeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categoria_tope")
public class Categoria_topeController {
    private final Categoria_topeService categoria_topeService;

    public Categoria_topeController(Categoria_topeService categoria_topeService){
        this.categoria_topeService = categoria_topeService;
    }

    @GetMapping("/listar")
    public List<Categoria_tope> listarCategoria_tope(){
        return categoria_topeService.listarCategoria_tope();
    }

    @GetMapping("/listar/{id}")
    public Object listarCategoriaTopeId(int id, RedirectAttributes redirectAttributes){
        Optional<Categoria_tope> categoriaTopeOptional = categoria_topeService.listarCategoria_topeId(id);
        if(categoriaTopeOptional.isPresent()){
            return categoria_topeService.listarCategoria_topeId(id);
        }else{
            redirectAttributes.addFlashAttribute("error", "La categoria tope no se encuentra en la base de datos!");
            return "redirect:/api/categoria_tope";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Categoria_tope> agregarCategoriaTope(@RequestBody Categoria_tope categoria_tope){
        Categoria_tope nuevaCategoriaTope = categoria_topeService.agregarCategoria_tope(categoria_tope);
        return new ResponseEntity<>(nuevaCategoriaTope, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarCategoriaTope(@PathVariable Integer id, @RequestBody Categoria_tope categoria_topeModificada){
        try{
            Categoria_tope categoriaTope = categoria_topeService.modificarCategoria_tope(id,categoria_topeModificada);
            return ResponseEntity.ok(categoriaTope);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+ e.getMessage());
        }
    }

    
}
