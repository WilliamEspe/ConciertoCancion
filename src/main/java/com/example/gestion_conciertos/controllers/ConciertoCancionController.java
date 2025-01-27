package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.ConciertoCancion;
import com.example.gestion_conciertos.services.ConciertoCancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conciertos-canciones")
public class ConciertoCancionController {

    @Autowired
    private ConciertoCancionService conciertoCancionService;

    // Asociar una canción a un concierto (crear relación)
    @PostMapping
    public ResponseEntity<ConciertoCancion> asociarCancionAConcierto(@RequestBody ConciertoCancion conciertoCancion) {
        ConciertoCancion nuevoConciertoCancion = conciertoCancionService.asociarCancionAConcierto(conciertoCancion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoConciertoCancion);
    }

    // Obtener todas las relaciones entre conciertos y canciones
    @GetMapping
    public ResponseEntity<Iterable<ConciertoCancion>> obtenerTodasLasRelaciones() {
        Iterable<ConciertoCancion> relaciones = conciertoCancionService.obtenerTodasLasRelaciones();
        return ResponseEntity.ok(relaciones);
    }

    // Obtener una relación entre concierto y canción por ID
    @GetMapping("/{conciertoId}/{cancionId}")
    public ResponseEntity<ConciertoCancion> obtenerRelacionPorId(@PathVariable Long conciertoId, @PathVariable Long cancionId) {
        ConciertoCancion relacion = conciertoCancionService.obtenerRelacionPorId(conciertoId, cancionId);
        return relacion != null ? ResponseEntity.ok(relacion) : ResponseEntity.notFound().build();
    }

    // Eliminar una relación entre un concierto y una canción
    @DeleteMapping("/{conciertoId}/{cancionId}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable Long conciertoId, @PathVariable Long cancionId) {
        boolean eliminado = conciertoCancionService.eliminarRelacion(conciertoId, cancionId);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
