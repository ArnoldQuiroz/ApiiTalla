package com.quiroz.apimitalla.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quiroz.apimitalla.Entity.Talla;
import com.quiroz.apimitalla.Service.TallaService;

@RestController
@RequestMapping("/tallas")
@CrossOrigin(origins = "*")
public class TallaController {

    @Autowired
    private TallaService service;

    @GetMapping
    public List<Talla> getAll() {
        return service.findAll();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API Talla funcionando correctamente 🚀");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talla> getById(@PathVariable Long id) {
        Optional<Talla> talla = service.findById(id);
        return talla.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Talla> create(@RequestBody Talla talla) {
        return ResponseEntity.status(201).body(service.save(talla));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talla> update(@PathVariable Long id, @RequestBody Talla talla) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        talla.setId(id);
        return ResponseEntity.ok(service.save(talla));
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
