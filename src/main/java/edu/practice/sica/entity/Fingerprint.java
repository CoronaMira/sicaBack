package edu.practice.sica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "catalogos")
@Data
public class Fingerprint{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] fingerprintTemplate;
    private LocalDateTime registrationDate;
    private Integer studentId;
}
