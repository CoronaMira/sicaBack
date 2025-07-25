package edu.practice.sica.service;

import edu.practice.sica.entity.Student;
import edu.practice.sica.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student create(Student estudiante) {
        // El método save del repositorio ya devuelve la entidad con el ID asignado.
        return studentRepository.save(estudiante);
    }

    public Student update(Integer id, Student updatedEstudiante) {
        updatedEstudiante.setId(id);

        studentRepository.findById(id)
                .map(existingStudent -> {

                    existingStudent.setNombre(updatedEstudiante.getNombre());
                    existingStudent.setEmail(updatedEstudiante.getEmail());
                    existingStudent.setEdad(updatedEstudiante.getEdad());
                    existingStudent.setSkills(updatedEstudiante.getSkills());
                    existingStudent.setImagenUrl(updatedEstudiante.getImagenUrl());
                    existingStudent.setImagen(updatedEstudiante.getImagen());
                    existingStudent.setTurno(updatedEstudiante.getTurno());
                    existingStudent.setIngenieria(updatedEstudiante.getIngenieria());
                    existingStudent.setTsu(updatedEstudiante.getTsu());
                    return studentRepository.update(id, existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con el id: " + id));

        return updatedEstudiante;
    }

    public void deleteById(Integer id) {
        if (studentRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Estudiante no encontrado con el id: " + id);
        }
        studentRepository.delete(id);
    }
}
