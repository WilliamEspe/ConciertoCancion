package com.example.gestion_conciertos.repositories;

import com.example.gestion_conciertos.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
}
