package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.Cancion;
import com.example.gestion_conciertos.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    public Cancion crearCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public Iterable<Cancion> obtenerCanciones() {
        return cancionRepository.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return cancionRepository.findById(id).orElse(null);
    }

    public boolean eliminarCancion(Long id) {
        if (cancionRepository.existsById(id)) {
            cancionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Cancion actualizarCancion(Long id, Cancion cancion) {
        Cancion cancionActualizada = cancionRepository.findById(id).orElse(null);
        if (cancionActualizada != null) {
            cancionActualizada.setNombre(cancion.getNombre());
            return cancionRepository.save(cancionActualizada);
        }
        return null;
    }

    public List<Cancion> obtenerTodasCanciones() {

        // Implementation to retrieve all songs

        return null; // Replace with actual implementation

    }
}
