package edu.practice.sica.controller;


import edu.practice.sica.entity.Person;
import edu.practice.sica.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {

        return ResponseEntity.ok(personService.create(person));
    }

    @PutMapping
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return ResponseEntity.ok(personService.update(id, person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return personService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
