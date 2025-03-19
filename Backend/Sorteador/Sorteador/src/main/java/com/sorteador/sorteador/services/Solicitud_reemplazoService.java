package com.sorteador.sorteador.services;

import com.sorteador.sorteador.model.Solicitud_reemplazo;

import java.util.List;
import java.util.Optional;

public interface Solicitud_reemplazoService {
    List<Solicitud_reemplazo> listarSolicitudReemplazo();
    Optional<Solicitud_reemplazo> listarSolicitudReemplazoId(int id);
    Solicitud_reemplazo agregarSolicitudReemplazo(Solicitud_reemplazo solicitudReemplazo);
    Solicitud_reemplazo modificarSolicitudReemplazo(int id, Solicitud_reemplazo solicitudReemplazoNueva);
}
