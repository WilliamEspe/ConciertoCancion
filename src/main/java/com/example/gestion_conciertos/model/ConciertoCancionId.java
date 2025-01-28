package com.example.gestion_conciertos.model;

import java.io.Serializable;
import java.util.Objects;

public class ConciertoCancionId implements Serializable {

    private Long concierto;
    private Long cancion;

    // Getters y Setters
    public Long getConcierto() {
        return concierto;
    }

    public void setConcierto(Long concierto) {
        this.concierto = concierto;
    }

    public Long getCancion() {
        return cancion;
    }

    public void setCancion(Long cancion) {
        this.cancion = cancion;
    }

    // HashCode y Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConciertoCancionId that = (ConciertoCancionId) o;
        return Objects.equals(concierto, that.concierto) && Objects.equals(cancion, that.cancion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concierto, cancion);
    }
}
