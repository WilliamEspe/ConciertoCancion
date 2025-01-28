package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.Cancion;
import com.example.gestion_conciertos.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    public List<Cancion> getAllCanciones() {
        return cancionRepository.findAll();
    }

    public Optional<Cancion> getCancionById(Long id) {
        return cancionRepository.findById(id);
    }

    public Cancion createCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Cancion updateCancion(Long id, Cancion cancionDetails) {
        Optional<Cancion> cancion = cancionRepository.findById(id);
        if (cancion.isPresent()) {
            Cancion updatedCancion = cancion.get();
            updatedCancion.setTitulo(cancionDetails.getTitulo());
            updatedCancion.setDuracion(cancionDetails.getDuracion());
            return cancionRepository.save(updatedCancion);
        }
        return null;
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}
