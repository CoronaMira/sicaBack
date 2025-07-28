package edu.practice.sica.repository;

import edu.practice.sica.entity.Visit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class VisitRepository {

    private final JdbcTemplate jdbcTemplate;

    public VisitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Visit> findAll() {
        String sql = "SELECT * FROM visits";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Visit.class));
    }

    public Optional<Visit> findById(Long id) {
        String sql = "SELECT * FROM visits WHERE id = ?";
        List<Visit> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Visit.class), id);
        return result.stream().findFirst();
    }

    public Optional<Visit> findByQrFolio(String qrFolio) {
        String sql = "SELECT * FROM visits WHERE qr_folio = ?";
        List<Visit> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Visit.class), qrFolio);
        return result.stream().findFirst();
    }

    public long save(Visit visit) {
        String sql = """
            INSERT INTO visits (visitor_name, visit_datetime, person_visited, authorized_by, visitor_photo_url, qr_folio,status)
            VALUES (?, ?, ?, ?, ?, ?,?)
        """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, visit.getVisitorName());
            ps.setTimestamp(2, Timestamp.valueOf(visit.getVisitDatetime()));
            ps.setString(3, visit.getPersonVisited());
            ps.setString(4, visit.getAuthorizedBy());
            ps.setString(5, visit.getVisitorPhotoUrl());
            ps.setString(6, visit.getQrFolio());
            ps.setString(7, visit.getStatus().name());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public int update(Long id, Visit visit) {
        String sql = """
            UPDATE visits SET visitor_name = ?, visit_datetime = ?, person_visited = ?,
            authorized_by = ?, visitor_photo_url = ?, qr_folio = ? WHERE id = ?
        """;
        return jdbcTemplate.update(sql,
                visit.getVisitorName(),
                visit.getVisitDatetime(),
                visit.getPersonVisited(),
                visit.getAuthorizedBy(),
                visit.getVisitorPhotoUrl(),
                visit.getQrFolio(),
                id
        );
    }

    public int delete(Long id) {
        String sql = "DELETE FROM visits WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
