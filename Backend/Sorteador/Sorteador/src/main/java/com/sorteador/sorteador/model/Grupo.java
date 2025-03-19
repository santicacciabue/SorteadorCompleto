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
@Table(name = "aut_grupo")
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "nombre")
    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "orden_grupo")
    private int orden_grupo;

    public int getOrden_grupo() {
        return this.orden_grupo;
    }

    public void setOrden_grupo(int orden_grupo) {
        this.orden_grupo = orden_grupo;
    }

    @ManyToOne
    @JoinColumn(name = "aut_categoria_id")
    private Categoria autCategoria;

    public void setCategoria(Categoria categoria) {
        this.autCategoria = categoria;
    }

    public Categoria getCategoria() {
        return autCategoria;
    }

    @OneToMany(mappedBy = "autGrupo")
    private List<Asignacion> asignacionList;
}
