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
@Table(name = "aut_asignacion")
public class Asignacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "estado")
    private boolean estado;

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "aut_grupo_id")
    private Grupo autGrupo;

    public Grupo getGrupo() {
        return autGrupo;
    }

    public Sorteo getSorteo() {
        return aut_sorteo_id;
    }

    @ManyToOne
    @JoinColumn(name = "aut_sorteo_id")
    private Sorteo aut_sorteo_id;

    public void setGrupo(Grupo grupo) {
        this.autGrupo = grupo;
    }

    public void setSorteo(Sorteo sorteo) {
        this.aut_sorteo_id = sorteo;
    }

    @OneToMany(mappedBy = "aut_asignacion_reemplazo_id")
    private List<Solicitud_reemplazo> solcitudReemplazoList;

    @OneToMany(mappedBy = "aut_asignacion_solicitante_id")
    private List<Solicitud_reemplazo> solcitudSolicitanteList;
}
