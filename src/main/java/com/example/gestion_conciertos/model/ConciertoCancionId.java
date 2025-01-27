package com.example.gestion_conciertos.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConciertoCancionId implements Serializable {

    private Long conciertoId;
    private Long cancionId;

    // Constructor vacío necesario para JPA
    public ConciertoCancionId() {}

    public ConciertoCancionId(Long conciertoId, Long cancionId) {
        this.conciertoId = conciertoId;
        this.cancionId = cancionId;
    }

    public Long getConciertoId() {
        return conciertoId;
    }

    public void setConciertoId(Long conciertoId) {
        this.conciertoId = conciertoId;
    }

    public Long getCancionId() {
        return cancionId;
    }

    public void setCancionId(Long cancionId) {
        this.cancionId = cancionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConciertoCancionId that = (ConciertoCancionId) o;
        return Objects.equals(conciertoId, that.conciertoId) &&
                Objects.equals(cancionId, that.cancionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conciertoId, cancionId);
    }
}
