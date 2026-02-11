package com.garcia.apihorariomed.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.garcia.apihorariomed.Entity.Horario;
import com.garcia.apihorariomed.Service.HorarioService;

@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "*") 
public class HorarioController {

    @Autowired
    private HorarioService service;

    @GetMapping
    public List<Horario> getAll() {
        return service.findAll();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API Horario funcionando correctamente 🚀");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getById(@PathVariable Long id) {
        Optional<Horario> horario = service.findById(id);
        return horario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Horario> create(@RequestBody Horario horario) {
        return ResponseEntity.status(201).body(service.save(horario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> update(@PathVariable Long id, @RequestBody Horario horario) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        horario.setId(id);
        return ResponseEntity.ok(service.save(horario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
