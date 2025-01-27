package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.Concierto;
import com.example.gestion_conciertos.services.ConciertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conciertos")
public class ConciertoController {

    @Autowired
    private ConciertoService conciertoService;

    // Crear un concierto
    @PostMapping
    public ResponseEntity<Concierto> crearConcierto(@RequestBody Concierto concierto) {
        Concierto nuevoConcierto = conciertoService.crearConcierto(concierto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoConcierto);
    }

    // Obtener todos los conciertos
    @GetMapping
    public ResponseEntity<List<Concierto>> obtenerConciertos() {
        List<Concierto> conciertos = conciertoService.obtenerTodosConciertos();
        return ResponseEntity.ok(conciertos);
    }

    // Obtener un concierto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Concierto> obtenerConciertoPorId(@PathVariable Long id) {
        Concierto concierto = conciertoService.obtenerConciertoPorId(id);
        return concierto != null ? ResponseEntity.ok(concierto) : ResponseEntity.notFound().build();
    }

    // Actualizar un concierto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Concierto> actualizarConcierto(@PathVariable Long id, @RequestBody Concierto concierto) {
        Concierto conciertoActualizado = conciertoService.actualizarConcierto(id, concierto);
        return conciertoActualizado != null ? ResponseEntity.ok(conciertoActualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un concierto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConcierto(@PathVariable Long id) {
        boolean eliminado = conciertoService.eliminarConcierto(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
