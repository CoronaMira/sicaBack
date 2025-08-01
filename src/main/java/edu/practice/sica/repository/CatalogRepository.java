package edu.practice.sica.repository;

import edu.practice.sica.entity.Catalog;
import edu.practice.sica.entity.enums.CatalogEnum;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogRepository {
    private final JdbcTemplate jdbcTemplate;

    public CatalogRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Catalog> findByType(CatalogEnum catalogEnum) {
        String sql = "SELECT * FROM catalogos WHERE type = ?";
        List<Catalog> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Catalog.class), catalogEnum.name());
        return result.stream().toList();
    }

    public List<Catalog> findByTypeAndFather(CatalogEnum catalogEnum, String idFather) {
        String sql = "SELECT * FROM catalogos WHERE type = ? AND ID_ROOT = ?";
        List<Catalog> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Catalog.class), catalogEnum.name(),idFather);
        return result.stream().toList();
    }

}
