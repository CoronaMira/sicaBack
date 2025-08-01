package edu.practice.sica.repository;

import edu.practice.sica.entity.AbsenceDto;
import edu.practice.sica.entity.TardinessDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public class IncidentRepository {
    private final JdbcTemplate jdbcTemplate;

    public IncidentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AbsenceDto> findAbsencesByPersonAndDateRange(Long personId, LocalDate startDate, LocalDate endDate) {
        String sql = """
            WITH RECURSIVE dates (date_col) AS (
              SELECT ?
              UNION ALL
              SELECT date_col + INTERVAL 1 DAY FROM dates WHERE date_col < ?
            )
            SELECT
              d.date_col AS date,
              ? AS person_id
            FROM
              dates d
            LEFT JOIN
              attendance_records ar ON DATE(ar.record_timestamp) = d.date_col AND ar.person_id = ?
            WHERE
              ar.id IS NULL
            ORDER BY
              d.date_col;
            """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AbsenceDto.class), startDate, endDate, personId, personId);
    }

    public List<TardinessDto> findTardinessByPersonAndDateRange(Long personId, LocalDate startDate, LocalDate endDate, LocalTime lateThresholdTime) {
        String sql = """
            SELECT
                person_id,
                MIN(record_timestamp) AS arrival_time
            FROM
                attendance_records
            WHERE
                person_id = ?
                AND record_type = 'ENTRADA' -- Asumimos 'ENTRADA' como tipo de registro de ingreso
                AND record_timestamp >= ? -- Fecha y hora de inicio del rango
                AND record_timestamp < ?  -- Fecha y hora de fin del rango
            GROUP BY
                person_id, DATE(record_timestamp)
            HAVING
                TIME(MIN(record_timestamp)) > ?
            ORDER BY
                arrival_time;
            """;

        LocalDateTime startRange = startDate.atStartOfDay();
        LocalDateTime endRange = endDate.plusDays(1).atStartOfDay();

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(TardinessDto.class),
                personId,
                startRange,
                endRange,
                lateThresholdTime
        );
    }
}
