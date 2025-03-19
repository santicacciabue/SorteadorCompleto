package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "aut_categoria_tope")
public class Categoria_tope {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "cantidad_min_auxiliar")
    private int cantidadMinAuxiliar;

    public int getcantidadMinAuxiliar() {
        return this.cantidadMinAuxiliar;
    }

    public void setcantidadMinAuxiliar(int cantidadMinAuxiliar) {
        this.cantidadMinAuxiliar = cantidadMinAuxiliar;
    }

    @Column(name = "cantidad_max_auxiliar")
    private int cantidadMaxAuxiliar;

    public int getcantidadMaxAuxiliar() {
        return this.cantidadMaxAuxiliar;
    }

    public void setcantidadMaxAuxiliar(int cantidadMaxAuxiliar) {
        this.cantidadMaxAuxiliar = cantidadMaxAuxiliar;
    }

    @Column(name = "cantidad_min_autoridad")
    private int cantidadMinAutoridad;

    public int getcantidadMinAutoridad() {
        return this.cantidadMinAutoridad;
    }

    public void setcantidadMinAutoridad(int cantidadMinAutoridad) {
        this.cantidadMinAutoridad = cantidadMinAutoridad;
    }

    @Column(name = "cantidad_max_autoridad")
    private int cantidadMaxAutoridad;

    public int getcantidadMaxAutoridad() {
        return this.cantidadMaxAutoridad;
    }

    public void setcantidadMaxAutoridad(int cantidadMaxAutoridad) {
        this.cantidadMaxAutoridad = cantidadMaxAutoridad;
    }

    @ManyToOne
    @JoinColumn(name = "aut_categoria_id")
    private Categoria autCategoria;

    public void setCategoria(Categoria autCategoria) {
        this.autCategoria = autCategoria;
    }

    public Categoria getCategoria() {
        return autCategoria;
    }

    
    
}
