package com.sorteador.sorteador.services;

import com.sorteador.sorteador.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listarCategorias();
    Optional<Categoria> listarCategoriaId(int id);
    Categoria agregarCategoria(Categoria categoria);
    Categoria modificarCategoria(int id, Categoria categoriaModificada);
}
