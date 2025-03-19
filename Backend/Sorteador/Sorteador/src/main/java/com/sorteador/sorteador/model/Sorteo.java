package com.sorteador.sorteador.model;

import java.time.LocalDate;
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
@Table(name = "aut_sorteo")
public class Sorteo {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "fecha")
    private LocalDate fecha;

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Column(name = "confirmado")
    private boolean confirmado;

    public boolean getConfirmado() {
        return this.confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Column(name = "dia_descriptivo")
    private String dia_descriptivo;

    public String getDia_descriptivo() {
        return this.dia_descriptivo;
    }

    public void setDia_descriptivo(String dia_descriptivo) {
        this.dia_descriptivo = dia_descriptivo;
    }

    @ManyToOne
    @JoinColumn(name = "aut_rel_producto_id")
    private Rel_producto aut_rel_producto_id;

    public void setProducto(Rel_producto aut_rel_producto_id) {
        this.aut_rel_producto_id = aut_rel_producto_id;
    }

    public Rel_producto getProducto() {
        return aut_rel_producto_id;
    }

    @OneToMany(mappedBy = "aut_sorteo_id")
    private List<Asignacion> asignacionList;
}
