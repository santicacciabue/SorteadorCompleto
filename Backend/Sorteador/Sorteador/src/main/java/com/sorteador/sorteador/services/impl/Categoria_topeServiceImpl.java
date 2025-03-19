package com.sorteador.sorteador.services.impl;



import com.sorteador.sorteador.model.Categoria;
import com.sorteador.sorteador.model.Categoria_tope;
import com.sorteador.sorteador.repositories.CategoriaRepository;
import com.sorteador.sorteador.repositories.Categoria_topeRepository;
import com.sorteador.sorteador.services.Categoria_topeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Categoria_topeServiceImpl implements Categoria_topeService {
    private final Categoria_topeRepository categoriaTopeRepository;
    private final CategoriaRepository categoriaRepository;

    public Categoria_topeServiceImpl(Categoria_topeRepository categoriaTopeRepository, CategoriaRepository categoriaRepository){
        this.categoriaTopeRepository = categoriaTopeRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria_tope> listarCategoria_tope(){
        return (List<Categoria_tope>)this.categoriaTopeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria_tope> listarCategoria_topeId(int id){
        return this.categoriaTopeRepository.findById(id);
    }

    @Transactional
    @Override
    public Categoria_tope agregarCategoria_tope(Categoria_tope categoria_tope){
        if(categoria_tope.getCategoria() != null && categoria_tope.getCategoria().getId() != 0){
            Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(categoria_tope.getId());
            if(categoriaOptional.isPresent()){
                categoria_tope.setCategoria(categoriaOptional.get());
            }else{
                throw new RuntimeException("Categoria no encontrado con id: "+categoria_tope.getCategoria().getId());
            }
        }
        return categoriaTopeRepository.save(categoria_tope);
    }

    @Transactional
    @Override
    public Categoria_tope modificarCategoria_tope(int id, Categoria_tope categoria_topeModificada){
        Categoria_tope categoriaTopeExistente = categoriaTopeRepository.findById(id).orElse(null);

        if(categoriaTopeExistente == null){
            throw new RuntimeException("La categoria con ID " + id + " no existe.");
        }
        categoriaTopeExistente.setcantidadMinAutoridad(categoria_topeModificada.getcantidadMinAutoridad());
        categoriaTopeExistente.setcantidadMaxAuxiliar(categoria_topeModificada.getcantidadMinAuxiliar());
        categoriaTopeExistente.setcantidadMaxAutoridad(categoria_topeModificada.getcantidadMaxAutoridad());
        categoriaTopeExistente.setcantidadMaxAuxiliar(categoria_topeModificada.getcantidadMaxAuxiliar());

        return categoriaTopeRepository.save(categoriaTopeExistente);
    }
}














