package edu.practice.sica.controller;

import edu.practice.sica.entity.Visit;
import edu.practice.sica.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<Visit> create(@RequestBody Visit visit) {
        Visit createdVisit = visitService.create(visit);
        return ResponseEntity.ok(createdVisit);
    }
    @GetMapping
    public ResponseEntity<List<Visit>> getAll() {
        return ResponseEntity.ok(visitService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Visit> getById(@PathVariable Long id) {
        return visitService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/folio/{qrFolio}")
    public ResponseEntity<Visit> getByQrFolio(@PathVariable String qrFolio) {
        return visitService.findByQrFolio(qrFolio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Visit> update(@PathVariable Long id, @RequestBody Visit visit) {
        Visit updatedVisit = visitService.update(id, visit);
        return ResponseEntity.ok(updatedVisit);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        visitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
