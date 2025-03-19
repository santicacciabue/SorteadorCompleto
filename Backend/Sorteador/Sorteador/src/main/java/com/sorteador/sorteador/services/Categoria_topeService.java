package com.sorteador.sorteador.services;

import com.sorteador.sorteador.model.Categoria_tope;

import java.util.List;
import java.util.Optional;

public interface Categoria_topeService {
    List<Categoria_tope> listarCategoria_tope();
    Optional<Categoria_tope> listarCategoria_topeId(int id);
    Categoria_tope agregarCategoria_tope(Categoria_tope categoria_tope);
    Categoria_tope modificarCategoria_tope(int id, Categoria_tope categoria_topeModificada);
}
