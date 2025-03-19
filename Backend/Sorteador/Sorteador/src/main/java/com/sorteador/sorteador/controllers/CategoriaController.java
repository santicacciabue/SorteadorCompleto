package com.sorteador.sorteador.controllers;

import com.sorteador.sorteador.model.Categoria;
import com.sorteador.sorteador.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/listar/{id}")
    public Object listarCategoriaId(@PathVariable int id, RedirectAttributes redirectAttributes){
        Optional<Categoria> categoriaOptional = categoriaService.listarCategoriaId(id);
        if(categoriaOptional.isPresent()){
            return categoriaService.listarCategoriaId(id);
        }else{
            redirectAttributes.addFlashAttribute("error", "La categoria no se encuentra en la base de datos!");
            return "redirect:/api/categoria";
        }

    }

    @PostMapping("/agregar")
    public ResponseEntity<Categoria> agregarCategoria(@RequestBody Categoria categoria){
        Categoria nuevaCategoria = categoriaService.agregarCategoria(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarCategoria(@PathVariable Integer id, @RequestBody Categoria categoriaModificada){
        try {
            Categoria categoria = categoriaService.modificarCategoria(id, categoriaModificada);
            return ResponseEntity.ok(categoria);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+ e.getMessage());
        }

    }

}
