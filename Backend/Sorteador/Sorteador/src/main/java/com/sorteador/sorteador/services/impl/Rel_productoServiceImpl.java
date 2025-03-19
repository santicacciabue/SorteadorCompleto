package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Categoria;
import com.sorteador.sorteador.model.Rel_producto;
import com.sorteador.sorteador.repositories.CategoriaRepository;
import com.sorteador.sorteador.repositories.Rel_productoRepository;
import com.sorteador.sorteador.services.Rel_productoService;


@Service
public class Rel_productoServiceImpl implements Rel_productoService {

    private final Rel_productoRepository rel_productoRepository;
    private final CategoriaRepository categoriaRepository;

    public Rel_productoServiceImpl(Rel_productoRepository rel_productoRepository, CategoriaRepository categoriaRepository) {
        this.rel_productoRepository = rel_productoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Rel_producto> listarProductos(){
        return (List<Rel_producto>)this.rel_productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Rel_producto> listarProductoId(int id){
        return this.rel_productoRepository.findById(id);
    }

    @Transactional
    @Override
    public Rel_producto agregarProducto(Rel_producto productoNuevo){
        if(productoNuevo.getCategoria() != null && productoNuevo.getCategoria().getId() != 0){
            Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(productoNuevo.getCategoria().getId());
            if(categoriaOptional.isPresent()){
                productoNuevo.setCategoria(categoriaOptional.get());
            }else{
                throw new RuntimeException("Categoria no encontrada con id: "+productoNuevo.getCategoria().getId());
            }
        }
        return rel_productoRepository.save(productoNuevo);
    }

    @Transactional
    @Override
    public Rel_producto modificarProducto(int id, Rel_producto productoModificado){
        Rel_producto productoExistente = this.rel_productoRepository.findById(id).orElse(null);
        if(productoExistente == null){
            throw new RuntimeException("El producto con el id "+id+" no existe.");
        }
        productoExistente.setNombre(productoModificado.getNombre());
        productoExistente.setOrden(productoModificado.getOrden());

        return this.rel_productoRepository.save(productoExistente);
    }

    @Transactional
    @Override
    public Rel_producto modificarCategoriaProducto(int idProducto, int categoriaNuevaId){
        Rel_producto productoExistente = this.rel_productoRepository.findById(idProducto)
            .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        

        Categoria nuevaCategoria = this.categoriaRepository.findById(categoriaNuevaId)
            .orElseThrow(()-> new RuntimeException("Categoria no encontrado"));


        productoExistente.setCategoria(nuevaCategoria);
        return rel_productoRepository.save(productoExistente);
    }

    
}
