package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "aut_categoria")
public class Categoria {

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

    @Column(name = "ultima_asignacion_semana")
    private int ultima_asignacion_semana;

    public int getUltima_asignacion_semana() {
        return this.ultima_asignacion_semana;
    }

    public void setUltima_asignacion_semana(int ultima_asignacion_semana) {
        this.ultima_asignacion_semana = ultima_asignacion_semana;
    }

    @Column(name = "ultima_asignacion_fecha")
    private LocalDate ultima_asignacion_fecha;

    public LocalDate getUltima_asignacion_fecha() {
        return this.ultima_asignacion_fecha;
    }

    public void setUltima_asignacion_fecha(LocalDate ultima_asignacion_fecha) {
        this.ultima_asignacion_fecha = ultima_asignacion_fecha;
    }

    @Column(name = "semanas_a_planificar")
    private int semanas_a_planificar;

    public int getSemanas_a_planificar() {
        return this.semanas_a_planificar;
    }

    public void setSemanas_a_planificar(int semanas_a_planificar) {
        this.semanas_a_planificar = semanas_a_planificar;
    }
    
    @OneToMany(mappedBy = "autCategoria")
    private List<Categoria_tope> categoriaTopeList;

    @OneToMany(mappedBy = "autCategoria")
    private List<Grupo> grupoList;

    @OneToMany(mappedBy = "autCategoria")
    private List<Rel_producto> relProductoList;
    
}
