package com.example.gestion_conciertos.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ConciertoCancion {

    @EmbeddedId
    private ConciertoCancionId id;

    @ManyToOne
    @MapsId("concierto") // Relaciona el campo concierto con la clave primaria compuesta
    @JoinColumn(name = "concierto_id")
    private Concierto concierto;

    @ManyToOne
    @MapsId("cancion") // Relaciona el campo cancion con la clave primaria compuesta
    @JoinColumn(name = "cancion_id")
    private Cancion cancion;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro = new Date();

    // Getters y Setters
    public ConciertoCancionId getId() {
        return id;
    }

    public void setId(ConciertoCancionId id) {
        this.id = id;
    }

    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
