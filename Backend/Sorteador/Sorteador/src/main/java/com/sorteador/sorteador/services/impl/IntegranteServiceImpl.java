package com.sorteador.sorteador.services.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.model.Integrante;
import com.sorteador.sorteador.repositories.GrupoRepository;
import com.sorteador.sorteador.repositories.IntegranteRepository;
import com.sorteador.sorteador.services.IntegranteService;



@Service
public class IntegranteServiceImpl implements IntegranteService {
    private final IntegranteRepository integranteRepository;
    private final GrupoRepository grupoRepository;

    //CONSTRUCTOR
    public IntegranteServiceImpl(IntegranteRepository integranteRepository, GrupoRepository grupoRepository) {
        this.integranteRepository = integranteRepository;
        this.grupoRepository = grupoRepository;
    }

    
    /** 
     * @return List<Integrante>
     */
    @Transactional(readOnly = true)
    @Override
    public List<Integrante> listarIntegrantes(){
        return (List<Integrante>)this.integranteRepository.findAll();
    }

    
    /** 
     * @param id
     * @return Optional<Integrante>
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Integrante> listarIntegranteId(int id){
        return this.integranteRepository.findById(id);
    }

    
    /** 
     * @param integrante
     * @return Integrante
     */
    @Transactional
    @Override
    public Integrante agregarIntegrante(Integrante integrante){
        if(integrante.getGrupo() != null && integrante.getGrupo().getId() != 0){
            Optional<Grupo> grupoOptional = grupoRepository.findById(integrante.getGrupo().getId());
            if(grupoOptional.isPresent()){
                integrante.setGrupo(grupoOptional.get());
            }
            else{ 
                throw new RuntimeException("Grupo no encontrado con id: "+ integrante.getGrupo().getId());
            }
        }
        return integranteRepository.save(integrante);
    }

    
    /** 
     * @param id
     * @param integranteModificado
     * @return Integrante
     */
    @Transactional
    @Override
    public Integrante modificarIntegrante(int id, Integrante integranteModificado){
        Integrante integranteExsistente = integranteRepository.findById(id).orElse(null);

        if(integranteExsistente == null){
            throw new RuntimeException("El integrante con el id "+id+" no existe.");
        }
        
        integranteExsistente.setNombre(integranteModificado.getNombre());
        integranteExsistente.setLegajo(integranteModificado.getLegajo());
        integranteExsistente.setRol(integranteModificado.getRol());

        return integranteRepository.save(integranteExsistente);
    }

    @Transactional
    @Override
    public Integrante modificarGrupoIntegrante(int idIntegrante, int grupoNuevoId){
        Integrante integrante = integranteRepository.findById(idIntegrante)
            .orElseThrow(()-> new RuntimeException("Integrante no encontrado"));

        Grupo nuevoGrupo = grupoRepository.findById(grupoNuevoId) 
            .orElseThrow(()-> new RuntimeException("Grupo no encontrado"));

        integrante.setGrupo(nuevoGrupo);
        return integranteRepository.save(integrante);
    }

}
