package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.Concierto;
import com.example.gestion_conciertos.repositories.ConciertoRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConciertoService {

    @Autowired
    private ConciertoRepository conciertoRepository;

    public Concierto crearConcierto(Concierto concierto) {
        return conciertoRepository.save(concierto);
    }

    public Iterable<Concierto> obtenerConciertos() {
        return conciertoRepository.findAll();
    }

    public Concierto obtenerConciertoPorId(Long id) {
        return conciertoRepository.findById(id).orElse(null);
    }

    public boolean eliminarConcierto(Long id) {
        if (conciertoRepository.existsById(id)) {
            conciertoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Concierto actualizarConcierto(Long id, Concierto concierto) {
        Concierto conciertoActualizado = conciertoRepository.findById(id).orElse(null);
        if (conciertoActualizado != null) {
            conciertoActualizado.setNombre(concierto.getNombre());
            return conciertoRepository.save(conciertoActualizado);
        }
        return null;
    }

    public List<Concierto> obtenerTodosConciertos() {

        // Dummy implementation, replace with actual logic

        return new ArrayList<Concierto>();

    }


}
