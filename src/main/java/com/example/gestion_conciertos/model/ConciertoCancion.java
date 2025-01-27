package com.example.gestion_conciertos.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class ConciertoCancion {

    @EmbeddedId
    private ConciertoCancionId id;

    @ManyToOne
    @MapsId("conciertoId")
    private Concierto concierto;

    @ManyToOne
    @MapsId("cancionId")
    private Cancion cancion;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y setters
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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

