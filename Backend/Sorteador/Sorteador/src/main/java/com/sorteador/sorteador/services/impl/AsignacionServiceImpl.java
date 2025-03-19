package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.model.Sorteo;
import com.sorteador.sorteador.repositories.AsignacionRepository;
import com.sorteador.sorteador.repositories.GrupoRepository;
import com.sorteador.sorteador.repositories.SorteoRepository;
import com.sorteador.sorteador.services.AsignacionService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionServiceImpl implements AsignacionService {
    private final AsignacionRepository asignacionRepository;
    private final GrupoRepository grupoRepository;
    private final SorteoRepository sorteoRepository;

    //CONSTRUCTOR
    public AsignacionServiceImpl (AsignacionRepository asignacionRepository, GrupoRepository grupoRepository, SorteoRepository sorteoRepository){
        this.asignacionRepository = asignacionRepository;
        this.grupoRepository = grupoRepository;
        this.sorteoRepository = sorteoRepository;
    }
    
    
    /** 
     * @return List<Asignacion>
     * LISTAR ASIGNACIONES
     */
    @Transactional(readOnly = true)
    @Override
    public List<Asignacion> listarAsignaciones(){
        return (List<Asignacion>)this.asignacionRepository.findAll();
    }

    
    /** 
     * @param id
     * @return Optional<Asignacion>
     * LISTAR ASIGNACION POR ID
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Asignacion> listarAsignacionId (int id) throws EntityNotFoundException{
        Optional<Asignacion> asignacionOptional = this.asignacionRepository.findById(id);
        if(asignacionOptional.isPresent()){
            return this.asignacionRepository.findById(id);
        }else{
            throw new EntityNotFoundException("Asignacion con id "+id+" no encontrada.");
        }

    }

    
    /** 
     * @param asignacion
     * @return Asignacion
     * AGREGAR ASIGNACION
     */
    @Transactional
    @Override
    public Asignacion agregarAsignacion(Asignacion asignacion) throws EntityNotFoundException{
        if(asignacion.getGrupo() != null && asignacion.getGrupo().getId() != 0){
            if(asignacion.getSorteo() != null && asignacion.getSorteo().getId() != 0){
                Optional<Grupo> grupoOptional = this.grupoRepository.findById(asignacion.getGrupo().getId());
                Optional<Sorteo> sorteOptional = this.sorteoRepository.findById(asignacion.getSorteo().getId());
                if(grupoOptional.isPresent()){
                    if(sorteOptional.isPresent()){
                        asignacion.setGrupo(grupoOptional.get());
                        asignacion.setSorteo(sorteOptional.get());
                    }else{
                        throw new EntityNotFoundException("Sorteo no encontrado con id: "+asignacion.getSorteo().getId());
                    }
                }else{
                    throw new EntityNotFoundException("Grupo no encontrado con id: "+asignacion.getGrupo().getId());
                }
            }
        }
        return this.asignacionRepository.save(asignacion);
    }

    
    /** 
     * @param id
     * @param asignacionModificada
     * @return Asignacion
     * MODIFICAR ASIGNACION
     */
    @Transactional
    @Override
    public Asignacion modificarAsignacion(int id, Asignacion asignacionModificada) throws EntityNotFoundException {
        Asignacion asignacionExistente = asignacionRepository.findById(id).orElse(null);

        if(asignacionExistente == null){
            throw new EntityNotFoundException("La Asignacion con ID " + id + " no existe.");
        }

        asignacionExistente.setEstado(asignacionModificada.getEstado());

        return asignacionRepository.save(asignacionExistente);
    }

    // @Transactional
    // @Override
    //  public void borrarAsignacion(int id){
    //      asignacionRepository.deleteById(id);
    //  }
}
