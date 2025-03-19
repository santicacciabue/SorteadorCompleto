package com.sorteador.sorteador.services.impl;

import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.model.Integrante;
import com.sorteador.sorteador.model.Solicitud_reemplazo;
import com.sorteador.sorteador.repositories.AsignacionRepository;
import com.sorteador.sorteador.repositories.IntegranteRepository;
import com.sorteador.sorteador.repositories.Solicitud_reemplazoRepository;
import com.sorteador.sorteador.services.Solicitud_reemplazoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class Solicitud_reemplazoServiceImpl implements Solicitud_reemplazoService {
    private final Solicitud_reemplazoRepository solicitudReemplazoRepository;
    private final IntegranteRepository integranteRepository;
    private final AsignacionRepository asignacionRepository;

    public Solicitud_reemplazoServiceImpl(Solicitud_reemplazoRepository solicitudReemplazoService, IntegranteRepository integranteRepository, AsignacionRepository asignacionRepository){
        this.solicitudReemplazoRepository = solicitudReemplazoService;
        this.integranteRepository = integranteRepository;
        this.asignacionRepository = asignacionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud_reemplazo> listarSolicitudReemplazo(){
        return (List<Solicitud_reemplazo>)this.solicitudReemplazoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Solicitud_reemplazo> listarSolicitudReemplazoId(int id){
        return this.solicitudReemplazoRepository.findById(id);
    }

    @Override
    @Transactional
    public Solicitud_reemplazo agregarSolicitudReemplazo(Solicitud_reemplazo solicitudReemplazo){
        if (solicitudReemplazo == null) {
            throw new IllegalArgumentException("La solicitud de reemplazo no puede ser nula.");
        }

        Integrante integranteSolicitante = integranteRepository.findById(solicitudReemplazo.getIntegranteSolicitante().getId()).
                orElseThrow(() -> new IllegalArgumentException("El integrante solicitante no existe"));

        Integrante integranteReemplazo = integranteRepository.findById(solicitudReemplazo.getIntegranteReemplazo().getId()).
                orElseThrow(() -> new IllegalArgumentException("El integrante reemplazante no existe"));;

        Asignacion asignacionSolicitante = asignacionRepository.findById(solicitudReemplazo.getAsignacionSolicitante().getId()).
                orElseThrow(() -> new IllegalArgumentException("La asignacion solicitante no existe"));;

        Asignacion asignacionReemplazo = asignacionRepository.findById(solicitudReemplazo.getAsignacionReemplazo().getId()).
                orElseThrow(() -> new IllegalArgumentException("La asignacion reemplazante no existe"));;

        solicitudReemplazo.setAsignacionSolicitante(asignacionSolicitante);
        solicitudReemplazo.setAsignacionReemplazo(asignacionReemplazo);
        solicitudReemplazo.setIntegranteSolicitante(integranteSolicitante);
        solicitudReemplazo.setIntegranteReemplazo(integranteReemplazo);

        return solicitudReemplazoRepository.save(solicitudReemplazo);

    }

    @Override
    @Transactional
    public Solicitud_reemplazo modificarSolicitudReemplazo(int id, Solicitud_reemplazo solicitudReemplazoNueva){
        Solicitud_reemplazo solicitudReemplazoExistente = solicitudReemplazoRepository.findById(id).orElse(null);

        if(solicitudReemplazoExistente == null){
            throw new RuntimeException("La solicitud con id "+id+" no existe");
        }

        solicitudReemplazoExistente.setNombre(solicitudReemplazoNueva.getNombre());
        solicitudReemplazoExistente.setDescripcion(solicitudReemplazoNueva.getDescripcion());
        solicitudReemplazoExistente.setFecha_solicitud(solicitudReemplazoNueva.getFecha_solicitud());
        solicitudReemplazoExistente.setSol_estado(solicitudReemplazoNueva.getSol_estado());

        return solicitudReemplazoRepository.save(solicitudReemplazoExistente);

    }
}
