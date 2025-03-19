package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.exceptions.EntityNotFoundException;
import com.sorteador.sorteador.exceptions.GroupExceededException;
import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.model.Integrante;

public interface GrupoService {
    List<Grupo> listarGrupos();
    Optional<Grupo> listarGrupoId(int id) throws EntityNotFoundException;
    Grupo agregarGrupo(Grupo grupo)throws  EntityNotFoundException;
    Grupo modificarGrupo(int id, Grupo grupoModificado)throws  EntityNotFoundException;
    Integrante agregarIntegranteAGrupo(int idIntegrante, int idGrupo) throws EntityNotFoundException, GroupExceededException;
}
