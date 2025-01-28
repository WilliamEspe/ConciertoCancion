package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.Cancion;
import com.example.gestion_conciertos.model.Concierto;
import com.example.gestion_conciertos.model.ConciertoCancion;
import com.example.gestion_conciertos.services.ConciertoCancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conciertos/{conciertoId}/canciones")
public class ConciertoCancionController {

    @Autowired
    private ConciertoCancionService conciertoCancionService;

    @PostMapping("/{cancionId}")
    public ConciertoCancion asociarCancionAConcierto(@PathVariable Long conciertoId, @PathVariable Long cancionId) {
        ConciertoCancion conciertoCancion = new ConciertoCancion();
        conciertoCancion.setConcierto(new Concierto(conciertoId));
        Cancion cancion = new Cancion();
        cancion.setId(cancionId);
        conciertoCancion.setCancion(cancion);
        return conciertoCancionService.asociarCancionAConcierto(conciertoCancion);
    }

    @DeleteMapping("/{cancionId}")
    public void eliminarCancionDeConcierto(@PathVariable Long conciertoId, @PathVariable Long cancionId) {
        conciertoCancionService.eliminarCancionDeConcierto(conciertoId, cancionId);
    }

    
}
