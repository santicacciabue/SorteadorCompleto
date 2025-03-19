package com.sorteador.sorteador.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sorteador.sorteador.model.Rel_producto;
import com.sorteador.sorteador.services.Rel_productoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/producto")
public class Rel_productoController {
    private final Rel_productoService productoService;

    public Rel_productoController(Rel_productoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listar")
    public List<Rel_producto> listarProductos(){
        return productoService.listarProductos();
    }

    @GetMapping("/listar/{id}")
    public Object listarProductoId(@PathVariable int id, RedirectAttributes redirect) {
        Optional<Rel_producto> productoOptional = productoService.listarProductoId(id);
        if(productoOptional.isPresent()){
            return productoService.listarProductoId(id);
        }else{
            redirect.addFlashAttribute("error", "El producto no se encuentra en la base de datos!");
            return "redirect:/api/producto";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Rel_producto>agregarProducto(@RequestBody Rel_producto producto) {
        Rel_producto productoNuevo = this.productoService.agregarProducto(producto);
        return new ResponseEntity<>(productoNuevo,HttpStatus.CREATED);
    }

    @PutMapping("modificar/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable int id, @RequestBody Rel_producto productoModificado) {
        try {
            Rel_producto producto = productoService.modificarProducto(id, productoModificado);
            return ResponseEntity.ok(producto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+ e.getMessage());
        }
    }

    @PutMapping("modificar/{id}/categoria/{categoriaId}")
    public ResponseEntity<?> modificarCategoriaProducto(@PathVariable int id, @PathVariable int categoriaId) {
        productoService.modificarCategoriaProducto(id, categoriaId);
        return ResponseEntity.ok(productoService.listarProductoId(id));
    }
    
    

}
