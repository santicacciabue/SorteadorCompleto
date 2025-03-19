package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Rel_producto;
import com.sorteador.sorteador.model.Sorteo;
import com.sorteador.sorteador.repositories.Rel_productoRepository;
import com.sorteador.sorteador.repositories.SorteoRepository;
import com.sorteador.sorteador.services.SorteoService;


@Service
public class SorteoServiceImpl implements SorteoService{
    private final SorteoRepository sorteoRepository;
    private final Rel_productoRepository rel_productoRepository;


    public SorteoServiceImpl(SorteoRepository sorteoRepository, Rel_productoRepository rel_productoRepository) {
        this.sorteoRepository = sorteoRepository;
        this.rel_productoRepository = rel_productoRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Sorteo> listarSorteos(){
        return (List<Sorteo>)this.sorteoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sorteo> listarSorteoId(int id){
        return this.sorteoRepository.findById(id);
    }

    @Transactional
    @Override
    public Sorteo agregarSorteo(Sorteo sorteoNuevo){
        if(sorteoNuevo.getProducto() != null && sorteoNuevo.getProducto().getId() != 0){
            Optional<Rel_producto> productoOptional = this.rel_productoRepository.findById(sorteoNuevo.getProducto().getId());
            if(productoOptional.isPresent()){
                sorteoNuevo.setProducto(productoOptional.get());
            }else{
                throw new RuntimeException("Producto no encontrada con id: "+sorteoNuevo.getProducto().getId());
            }
        }
        return sorteoRepository.save(sorteoNuevo);
    }

    @Transactional
    @Override
    public Sorteo modificarSorteo(int id, Sorteo sorteoModificado){
        Sorteo sorteoExistente = this.sorteoRepository.findById(id).orElse(null);
        if(sorteoExistente == null){
            throw new RuntimeException("El sorteo con el id "+id+" no existe.");
        }
        sorteoExistente.setFecha(sorteoModificado.getFecha());
        sorteoExistente.setDia_descriptivo(sorteoModificado.getDia_descriptivo());
        sorteoExistente.setConfirmado(sorteoModificado.getConfirmado());

        return this.sorteoRepository.save(sorteoExistente);
    }    

}
