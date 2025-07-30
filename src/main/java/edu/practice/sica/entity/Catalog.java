package edu.practice.sica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "catalogos")
@Data
public class Catalog {
    @Id
    int id;
    @Column(name = "description")
    String description;
    @Column(name = "type")
    String type;
}

