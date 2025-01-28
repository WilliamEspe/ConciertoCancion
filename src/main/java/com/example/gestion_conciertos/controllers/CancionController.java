package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.Cancion;
import com.example.gestion_conciertos.services.CancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    @GetMapping
    public List<Cancion> getAllCanciones() {
        return cancionService.getAllCanciones();
    }

    @GetMapping("/{id}")
    public Optional<Cancion> getCancionById(@PathVariable Long id) {
        return cancionService.getCancionById(id);
    }

    @PostMapping
    public Cancion createCancion(@RequestBody Cancion cancion) {
        return cancionService.createCancion(cancion);
    }

    @PutMapping("/{id}")
    public Cancion updateCancion(@PathVariable Long id, @RequestBody Cancion cancionDetails) {
        return cancionService.updateCancion(id, cancionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCancion(@PathVariable Long id) {
        cancionService.deleteCancion(id);
    }
}
