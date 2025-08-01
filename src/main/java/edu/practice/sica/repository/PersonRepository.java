package edu.practice.sica.repository;

import edu.practice.sica.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll() {
        String sql = "SELECT * FROM person";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> findById(Long id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        List<Person> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), id);
        return result.stream().findFirst();
    }

    public int save(Person person) {
        String sql = """
            INSERT INTO person (first_name, last_name, middle_name, type, enrollment, degree, shift, entry_time, departure_time )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getMiddleName());
            ps.setString(4, person.getType());
            ps.setString(5, person.getEnrollment());
            ps.setString(6, person.getDegree());
            ps.setString(7, person.getShift());
            ps.setString(8, person.getEntryTime());
            ps.setString(9, person.getDepartureTime());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();


    }

    public int update(Long id, Person person) {
        String sql = """
            UPDATE person SET first_name = ?, last_name = ?, middle_name = ?, type = ?, 
            enrollment = ?, degree = ?, shift = ?, entry_time = ?, departure_time = ?,  WHERE id = ?
        """;
        return jdbcTemplate.update(sql,
                person.getFirstName(),
                person.getLastName(),
                person.getMiddleName(),
                person.getType(),
                person.getEnrollment(),
                person.getDegree(),
                person.getShift(),
                id
        );
    }

    public int delete(Long id) {
        String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


}
