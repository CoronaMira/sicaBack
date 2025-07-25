package edu.practice.sica.repository;

import edu.practice.sica.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM estudiantes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    public Optional<Student> findById(Integer id) {
        String sql = "SELECT * FROM estudiantes WHERE ID = ?";
        List<Student> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return result.stream().findFirst();
    }

    public Student save(Student student) {
        String sql = """
            INSERT INTO estudiantes (NOMBRE, EMAIL, EDAD, SKILLS, IMAGEN_URL, IMAGEN, TURNO, INGENIERIA, TSU)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getNombre());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getEdad());
            ps.setString(4, student.getSkills());
            ps.setString(5, student.getImagenUrl());
            ps.setBytes(6, student.getImagen());
            ps.setObject(7, student.getTurno());
            ps.setObject(8, student.getIngenieria());
            ps.setObject(9, student.getTsu());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            student.setId(keyHolder.getKey().intValue());
        }
        return student;
    }

    public int update(Integer id, Student student) {
        String sql = """
            UPDATE estudiantes SET NOMBRE = ?, EMAIL = ?, EDAD = ?, SKILLS = ?, IMAGEN_URL = ?,
            IMAGEN = ?, TURNO = ?, INGENIERIA = ?, TSU = ? WHERE ID = ?
        """;
        return jdbcTemplate.update(sql,
                student.getNombre(),
                student.getEmail(),
                student.getEdad(),
                student.getSkills(),
                student.getImagenUrl(),
                student.getImagen(),
                student.getTurno(),
                student.getIngenieria(),
                student.getTsu(),
                id
        );
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM estudiantes WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }
}
