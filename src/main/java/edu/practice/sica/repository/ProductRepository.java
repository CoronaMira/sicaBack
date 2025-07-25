package edu.practice.sica.repository;

import edu.practice.sica.entity.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    public Optional<Product> findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<Product> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), id);
        return result.stream().findFirst();
    }

    public Long save(Product product) {
        String sql = """
            INSERT INTO product (name, description, price, stock, category)
            VALUES (?, ?, ?, ?, ?)
        """;
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setString(5, product.getCategory());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    public int update(Long id, Product product) {
        String sql = """
            UPDATE product
            SET name = ?, description = ?, price = ?, stock = ?, category = ?
            WHERE id = ?
        """;
        return jdbcTemplate.update(sql,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                id
        );
    }

    public int delete(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
