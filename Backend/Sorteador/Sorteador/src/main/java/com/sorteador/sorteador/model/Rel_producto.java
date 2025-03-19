package com.sorteador.sorteador.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_rel_producto")
public class Rel_producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column (name = "nombre")
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column (name = "orden")
    private int orden;

    public int getOrden() {
        return this.orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @ManyToOne
    @JoinColumn(name = "aut_categorias_id")
    private Categoria autCategoria;

    public void setCategoria(Categoria categoria){
        this.autCategoria = categoria;
    }

    public Categoria getCategoria(){
        return this.autCategoria;
    }

    @OneToMany(mappedBy = "aut_rel_producto_id")
    private List<Sorteo> sorteoList;
    
}
