package com.example.gestion_conciertos.repositories;

import com.example.gestion_conciertos.model.Concierto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConciertoRepository extends JpaRepository<Concierto, Long> {
}
