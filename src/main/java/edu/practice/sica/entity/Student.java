package edu.practice.sica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "estudiantes")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EDAD")
    private int edad;

    @Column(name = "FECHA_REGISTRO")
    private Timestamp fechaRegistro;

    @Column(name = "SKILLS")
    private String skills;

    @Column(name = "IMAGEN_URL")
    private String imagenUrl;

    @Column(name = "IMAGEN")
    @Lob // Para campos grandes como LONGBLOB
    private byte[] imagen;

    @Column(name = "TURNO")
    private Integer turno;

    @Column(name = "INGENIERIA")
    private Integer ingenieria;

    @Column(name = "TSU")
    private Integer tsu;
}
