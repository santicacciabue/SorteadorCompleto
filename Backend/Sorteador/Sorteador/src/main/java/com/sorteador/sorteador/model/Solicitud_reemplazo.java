package com.sorteador.sorteador.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_solicitud_reemplazo")
public class Solicitud_reemplazo {
    
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

    @Column(name = "descripcion")
    private String descripcion;

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "fecha_solicitud")
    private LocalDate fecha_solicitud;

    public LocalDate getFecha_solicitud() {
        return this.fecha_solicitud;
    }

    public void setFecha_solicitud(LocalDate fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    @Column(name = "sol_estado")  //Enum
    private String sol_estado;


	public String getSol_estado() {
		return this.sol_estado;
	}

	public void setSol_estado(String sol_estado) {
		this.sol_estado = sol_estado;
	}

    @ManyToOne
    @JoinColumn(name = "aut_empleado_solicitante")
    private Integrante aut_integrante_solicitante_id;

    public Integrante getIntegranteSolicitante() {
        return aut_integrante_solicitante_id;
    }

    public void setIntegranteSolicitante(Integrante aut_integrante_solicitante_id) {
        this.aut_integrante_solicitante_id = aut_integrante_solicitante_id;
    }

    @ManyToOne
    @JoinColumn(name = "aut_empleado_reemplazo")
    private Integrante aut_integrante_reemplazo_id;

    public Integrante getIntegranteReemplazo() {
        return aut_integrante_reemplazo_id;
    }

    public void setIntegranteReemplazo(Integrante aut_integrante_reemplazo_id) {
        this.aut_integrante_reemplazo_id = aut_integrante_reemplazo_id;
    }

    @ManyToOne
    @JoinColumn(name = "aut_asignacion_solicitante")
    private Asignacion aut_asignacion_solicitante_id;

    public Asignacion getAsignacionSolicitante() {
        return aut_asignacion_solicitante_id;
    }

    public void setAsignacionSolicitante(Asignacion aut_asignacion_solicitante_id) {
        this.aut_asignacion_solicitante_id = aut_asignacion_solicitante_id;
    }

    @ManyToOne
    @JoinColumn(name = "aut_asignacion_reemplazo")
    private Asignacion aut_asignacion_reemplazo_id;

    public Asignacion getAsignacionReemplazo() {
        return aut_asignacion_reemplazo_id;
    }

    public void setAsignacionReemplazo(Asignacion aut_asignacion_reemplazo_id) {
        this.aut_asignacion_reemplazo_id = aut_asignacion_reemplazo_id;
    }

}
