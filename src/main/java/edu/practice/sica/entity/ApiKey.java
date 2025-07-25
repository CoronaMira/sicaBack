package edu.practice.sica.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "api_keys")
@Data
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String apiKey;
    private boolean active = true;
}
