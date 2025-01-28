package com.example.gestion_conciertos.controllers;

import com.example.gestion_conciertos.model.Concierto;
import com.example.gestion_conciertos.services.ConciertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conciertos")
public class ConciertoController {

    @Autowired
    private ConciertoService conciertoService;

    @GetMapping
    public List<Concierto> getAllConciertos() {
        return conciertoService.getAllConciertos();
    }

    @GetMapping("/{id}")
    public Optional<Concierto> getConciertoById(@PathVariable Long id) {
        return conciertoService.getConciertoById(id);
    }

    @PostMapping
    public Concierto createConcierto(@RequestBody Concierto concierto) {
        return conciertoService.createConcierto(concierto);
    }

    @PutMapping("/{id}")
    public Concierto updateConcierto(@PathVariable Long id, @RequestBody Concierto conciertoDetails) {
        return conciertoService.updateConcierto(id, conciertoDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteConcierto(@PathVariable Long id) {
        conciertoService.deleteConcierto(id);
    }
}
