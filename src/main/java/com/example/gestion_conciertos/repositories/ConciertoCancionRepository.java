package com.example.gestion_conciertos.repositories;

import com.example.gestion_conciertos.model.ConciertoCancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConciertoCancionRepository extends JpaRepository<ConciertoCancion, com.example.gestion_conciertos.model.ConciertoCancionId> {
}
