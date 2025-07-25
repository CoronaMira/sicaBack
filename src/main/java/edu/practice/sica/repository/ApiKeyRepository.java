package edu.practice.sica.repository;

import edu.practice.sica.entity.ApiKey;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class ApiKeyRepository  {
    private final JdbcTemplate jdbcTemplate;

    public ApiKeyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<ApiKey> findByApiKeyAndActiveTrue(String key) {
        String sql = "SELECT * FROM api_keys WHERE api_key = ? AND active = true";
        var result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ApiKey.class), key);
        return result.stream().findFirst();
    }

    public Long save(String clientName, String generatedKey) {
        String sql = "INSERT INTO api_keys (name, api_key) VALUES (?, ?)";
        var keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, clientName);
            ps.setString(2, generatedKey);
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }}
