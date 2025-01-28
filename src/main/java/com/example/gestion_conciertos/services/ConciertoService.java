package com.example.gestion_conciertos.services;

import com.example.gestion_conciertos.model.Concierto;
import com.example.gestion_conciertos.repositories.ConciertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConciertoService {

    @Autowired
    private ConciertoRepository conciertoRepository;

    public List<Concierto> getAllConciertos() {
        return conciertoRepository.findAll();
    }

    public Optional<Concierto> getConciertoById(Long id) {
        return conciertoRepository.findById(id);
    }

    public Concierto createConcierto(Concierto concierto) {
        return conciertoRepository.save(concierto);
    }

    public Concierto updateConcierto(Long id, Concierto conciertoDetails) {
        Optional<Concierto> concierto = conciertoRepository.findById(id);
        if (concierto.isPresent()) {
            Concierto updatedConcierto = concierto.get();
            updatedConcierto.setNombre(conciertoDetails.getNombre());
            updatedConcierto.setFecha(conciertoDetails.getFecha());
            return conciertoRepository.save(updatedConcierto);
        }
        return null;
    }

    public void deleteConcierto(Long id) {
        conciertoRepository.deleteById(id);
    }
}
