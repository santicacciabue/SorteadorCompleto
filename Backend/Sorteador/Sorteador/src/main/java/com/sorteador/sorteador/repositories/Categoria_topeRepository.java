package com.sorteador.sorteador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorteador.sorteador.model.Categoria_tope;
import java.util.Optional;

@Repository
public interface Categoria_topeRepository extends JpaRepository<Categoria_tope, Integer> {
    Optional<Categoria_tope> findByAutCategoriaId(int id);
}
