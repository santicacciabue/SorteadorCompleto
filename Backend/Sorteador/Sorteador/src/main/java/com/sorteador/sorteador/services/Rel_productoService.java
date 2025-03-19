package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.model.Rel_producto;

public interface Rel_productoService {
    List<Rel_producto> listarProductos();
    Optional<Rel_producto> listarProductoId(int id);
    Rel_producto agregarProducto(Rel_producto productoNuevo);
    Rel_producto modificarProducto(int id, Rel_producto productoModificado);
    Rel_producto modificarCategoriaProducto(int idProducto, int categoriaNuevaId);
}
