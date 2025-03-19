package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.model.Sorteo;

public interface SorteoService{ 
    List<Sorteo> listarSorteos();
    Optional<Sorteo> listarSorteoId(int id);
    Sorteo agregarSorteo(Sorteo sorteoNuevo);
    Sorteo modificarSorteo(int id, Sorteo sorteoModificado);

}
