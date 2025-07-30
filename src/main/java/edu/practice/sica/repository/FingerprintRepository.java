package edu.practice.sica.repository;

import edu.practice.sica.entity.Fingerprint;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class FingerprintRepository {

    private final JdbcTemplate jdbcTemplate;

    public FingerprintRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Fingerprint save(Fingerprint fingerprint) {
        String sql = "INSERT INTO fingerprints (fingerprint_template, student_id, registration_date) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBytes(1, fingerprint.getFingerprintTemplate());
            ps.setInt(2, fingerprint.getStudentId());
            ps.setTimestamp(3, Timestamp.valueOf(fingerprint.getRegistrationDate()));
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            fingerprint.setId(keyHolder.getKey().intValue());
        }
        return fingerprint;
    }

    public List<Fingerprint> findByStudentId(Integer studentId) {
        String sql = "SELECT * FROM fingerprints WHERE student_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fingerprint.class), studentId);
    }

    public Optional<Fingerprint> findById(Integer id) {
        String sql = "SELECT * FROM fingerprints WHERE id = ?";
        List<Fingerprint> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fingerprint.class), id);
        return result.stream().findFirst();
    }

    public List<Fingerprint> findAll() {
        String sql = "SELECT * FROM fingerprints";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fingerprint.class));
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM fingerprints WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}