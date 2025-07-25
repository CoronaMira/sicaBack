package edu.practice.databaseconnection.service;

import edu.practice.databaseconnection.entity.Person;
import edu.practice.databaseconnection.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person create(Person person) {
        var personId = personRepository.save(person);
        person.setId((long) personId);
        return person;
    }

    public Person update(Long id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.findById(id)
                .map(existing -> {
                    existing.setFirstName(updatedPerson.getFirstName());
                    existing.setLastName(updatedPerson.getLastName());
                    existing.setMiddleName(updatedPerson.getMiddleName());
                    existing.setType(updatedPerson.getType());
                    existing.setEnrollment(updatedPerson.getEnrollment());
                    existing.setDegree(updatedPerson.getDegree());
                    existing.setShift(updatedPerson.getShift());
                    existing.setId(id);
                    return personRepository.update(id, existing);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        return updatedPerson;
    }

    public void deleteById(Long id) {
        personRepository.delete(id);
    }
}
