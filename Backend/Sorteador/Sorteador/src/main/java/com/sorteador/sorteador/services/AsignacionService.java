package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.exceptions.EntityNotFoundException;
import com.sorteador.sorteador.model.Asignacion;

public interface AsignacionService {
    List<Asignacion> listarAsignaciones();
    Optional<Asignacion> listarAsignacionId(int id)throws EntityNotFoundException;
    Asignacion agregarAsignacion(Asignacion asignacion)throws EntityNotFoundException;
    Asignacion modificarAsignacion(int id, Asignacion asignacionModificada)throws EntityNotFoundException;
    //void borrarAsignacion(int id);
}
