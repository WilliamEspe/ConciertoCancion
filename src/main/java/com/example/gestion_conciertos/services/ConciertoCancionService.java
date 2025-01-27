package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.ConciertoCancion;
import com.example.gestion_conciertos.model.ConciertoCancionId;
import com.example.gestion_conciertos.repositories.ConciertoCancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConciertoCancionService {

    @Autowired
    private ConciertoCancionRepository conciertoCancionRepository;

    public ConciertoCancion asociarCancionAConcierto(ConciertoCancion conciertoCancion) {
        return conciertoCancionRepository.save(conciertoCancion);
    }

    public Iterable<ConciertoCancion> obtenerTodasLasRelaciones() {
        return conciertoCancionRepository.findAll();
    }

    public ConciertoCancion obtenerRelacionPorId(Long conciertoId, Long cancionId) {
        ConciertoCancionId id = new ConciertoCancionId(conciertoId, cancionId);
        return conciertoCancionRepository.findById(id).orElse(null);
    }

    public boolean eliminarRelacion(Long conciertoId, Long cancionId) {
        ConciertoCancionId id = new ConciertoCancionId(conciertoId, cancionId);
        if (conciertoCancionRepository.existsById(id)) {
            conciertoCancionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
