package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.ConciertoCancion;
import com.example.gestion_conciertos.repositories.ConciertoCancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.gestion_conciertos.model.ConciertoCancionId;
import org.springframework.stereotype.Service;

@Service
public class ConciertoCancionService {

    @Autowired
    private ConciertoCancionRepository conciertoCancionRepository;

    public ConciertoCancion asociarCancionAConcierto(ConciertoCancion conciertoCancion) {
        return conciertoCancionRepository.save(conciertoCancion);
    }

    public void eliminarCancionDeConcierto(Long conciertoId, Long cancionId) {
        conciertoCancionRepository.deleteById(new ConciertoCancionId());
    }
}
