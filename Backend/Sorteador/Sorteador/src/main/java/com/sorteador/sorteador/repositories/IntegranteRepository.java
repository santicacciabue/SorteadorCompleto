package com.sorteador.sorteador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.model.Integrante;

public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {
    Integer countByAutGrupo(Grupo grupo);
    Integer countByRolAndAutGrupo(String rol, Grupo grupo);
}
