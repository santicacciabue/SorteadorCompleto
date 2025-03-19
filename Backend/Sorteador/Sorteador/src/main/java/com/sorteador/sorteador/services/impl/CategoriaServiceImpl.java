package com.sorteador.sorteador.services.impl;

import com.sorteador.sorteador.model.Categoria;
import com.sorteador.sorteador.repositories.CategoriaRepository;
import com.sorteador.sorteador.services.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    //CONSTRUCTOR
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    
    /** 
     * @return List<Categoria>
     * LISTAR CATEGORIAS
     */
    @Transactional(readOnly = true)
    @Override
    public List<Categoria> listarCategorias() {
        return (List<Categoria>)this.categoriaRepository.findAll();
    }

    
    /** 
     * @param id
     * @return Optional<Categoria>
     * LISTAR CATEGORIA POR ID
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria> listarCategoriaId(int id) {
        return this.categoriaRepository.findById(id);
    }

    
    /** 
     * @param categoria
     * @return Categoria
     * AGREGAR CATEGORIA
     */
    @Transactional
    @Override
    public Categoria agregarCategoria(Categoria categoria){

        return categoriaRepository.save(categoria);

    }

    
    /** 
     * @param id
     * @param categoriaModificada
     * @return Categoria
     * MODIFICAR CATEGORIA
     */
    @Transactional
    @Override
    public Categoria modificarCategoria(int id, Categoria categoriaModificada) {
        Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
        if(categoriaExistente == null){
            throw new RuntimeException("La Categoria con ID " + id + " no existe.");
        }

        categoriaExistente.setNombre(categoriaModificada.getNombre());
        categoriaExistente.setUltima_asignacion_fecha(categoriaModificada.getUltima_asignacion_fecha());
        categoriaExistente.setSemanas_a_planificar(categoriaModificada.getSemanas_a_planificar());
        categoriaExistente.setUltima_asignacion_semana(categoriaModificada.getUltima_asignacion_semana());

        return categoriaRepository.save(categoriaExistente);
    }
}
