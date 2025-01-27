package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.Cancion;
import com.example.gestion_conciertos.services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    // Crear una canción
    @PostMapping
    public ResponseEntity<Cancion> crearCancion(@RequestBody Cancion cancion) {
        Cancion nuevaCancion = cancionService.crearCancion(cancion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
    }

    // Obtener todas las canciones
    @GetMapping
    public ResponseEntity<List<Cancion>> obtenerCanciones() {
        List<Cancion> canciones = cancionService.obtenerTodasCanciones();
        return ResponseEntity.ok(canciones);
    }

    // Obtener una canción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cancion> obtenerCancionPorId(@PathVariable Long id) {
        Cancion cancion = cancionService.obtenerCancionPorId(id);
        return cancion != null ? ResponseEntity.ok(cancion) : ResponseEntity.notFound().build();
    }

    // Actualizar una canción por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cancion> actualizarCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        Cancion cancionActualizada = cancionService.actualizarCancion(id, cancion);
        return cancionActualizada != null ? ResponseEntity.ok(cancionActualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar una canción por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCancion(@PathVariable Long id) {
        boolean eliminado = cancionService.eliminarCancion(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
