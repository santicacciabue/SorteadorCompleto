package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.model.Integrante;

public interface IntegranteService {
    List<Integrante> listarIntegrantes();
    Optional<Integrante> listarIntegranteId(int id);
    Integrante agregarIntegrante(Integrante integrante);
    Integrante modificarIntegrante(int id, Integrante integranteModificado);
    Integrante modificarGrupoIntegrante(int idIntegrante, int grupoNuevoId);
}
