package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.exceptions.GroupExceededException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.exceptions.EntityNotFoundException;
import com.sorteador.sorteador.model.Categoria;
import com.sorteador.sorteador.model.Categoria_tope;
import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.model.Integrante;
import com.sorteador.sorteador.repositories.CategoriaRepository;
import com.sorteador.sorteador.repositories.Categoria_topeRepository;
import com.sorteador.sorteador.repositories.GrupoRepository;
import com.sorteador.sorteador.repositories.IntegranteRepository;
import com.sorteador.sorteador.services.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{
    private final GrupoRepository grupoRepository;
    private final CategoriaRepository categoriaRepository;
    private final IntegranteRepository integranteRepository;
    private final Categoria_topeRepository categoria_topeRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository, CategoriaRepository categoriaRepository, IntegranteRepository integranteRepository, Categoria_topeRepository categoria_topeRepository) {
        this.grupoRepository = grupoRepository;
        this.categoriaRepository = categoriaRepository;
        this.integranteRepository = integranteRepository;
        this.categoria_topeRepository = categoria_topeRepository;
    }

    
    @Transactional(readOnly = true)
    @Override
    public List<Grupo> listarGrupos(){
        return (List<Grupo>)this.grupoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Grupo> listarGrupoId(int id) throws EntityNotFoundException{
        Optional<Grupo> grupoOptional = this.grupoRepository.findById(id);
        if(grupoOptional.isPresent()){
            return this.grupoRepository.findById(id);
        }else{
            throw new EntityNotFoundException("Grupo con id "+id+" no encontrado.");
        }
    }

    @Transactional
    @Override
    public Grupo agregarGrupo(Grupo grupo) throws  EntityNotFoundException{
        if(grupo.getCategoria() != null && grupo.getCategoria().getId() != 0){
            Optional<Categoria> categoriaOptional = this.categoriaRepository.findById(grupo.getCategoria().getId());
            if(categoriaOptional.isPresent()){
                grupo.setCategoria(categoriaOptional.get());
            }else{
                throw new EntityNotFoundException("Categoria no encontrada con id: "+grupo.getCategoria().getId());
            }
        }
        return grupoRepository.save(grupo);   
    }

    @Transactional
    @Override
    public Grupo modificarGrupo(int id, Grupo grupoModificado) throws  EntityNotFoundException{
        Grupo grupoExistente = grupoRepository.findById(id).orElse(null);

        if(grupoExistente == null){
            throw new EntityNotFoundException("El grupo con el id "+id+" no existe.");
        }

        grupoExistente.setNombre(grupoModificado.getNombre());
        grupoExistente.setOrden_grupo(grupoModificado.getOrden_grupo());

        return grupoRepository.save(grupoExistente);
    }

    @Transactional
    @Override
    public Integrante agregarIntegranteAGrupo(int idIntegrante, int idGrupo) throws EntityNotFoundException,GroupExceededException{
        Integrante integrante = integranteRepository.findById(idIntegrante).orElse(null);
        if(integrante.getGrupo() != null && integrante.getGrupo().getId() != 0){
            throw new RuntimeException("El integrante ya pertenece a un grupo");
        }  

         // Verificar existencia del grupo
         Grupo grupo = grupoRepository.findById(idGrupo)
            .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado."));

        //Verificar si el grupo ya tiene cupo suficiente en la categoría
        System.out.println(grupo);
        Categoria_tope categoriaTope = categoria_topeRepository.findByAutCategoriaId(grupo.getCategoria().getId())
            .orElseThrow(() -> new EntityNotFoundException("Categoria tope no encontrada."));
           

        int cantidadAuxiliaresEnGrupo = integranteRepository.countByRolAndAutGrupo("auxiliar", grupo);
        int cantidadAutoridadesEnGrupo = integranteRepository.countByRolAndAutGrupo("autoridad", grupo);

        if(cantidadAutoridadesEnGrupo == categoriaTope.getcantidadMaxAutoridad()){
            throw new GroupExceededException("Cantidad maxima de autoridades alcanzada.");
        }

        if(cantidadAuxiliaresEnGrupo == categoriaTope.getcantidadMaxAuxiliar()){
            throw new GroupExceededException("Cantidad maxima de auxiliares alcanzada.");
        }

        integrante.setGrupo(grupo);
        return integranteRepository.save(integrante);
        
    } 
}
