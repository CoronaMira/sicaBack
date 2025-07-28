package edu.practice.sica.entity;

import edu.practice.sica.entity.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visitor_name", nullable = false)
    private String visitorName;

    @Column(name = "visit_datetime", nullable = false)
    private LocalDateTime visitDatetime;

    @Column(name = "person_visited", nullable = false)
    private String personVisited;

    @Column(name = "authorized_by", nullable = true)
    private String authorizedBy;

    @Column(name = "visitor_photo_url")
    private String visitorPhotoUrl;

    @Column(name = "qr_folio", nullable = false, unique = true)
    private String qrFolio;

    @Column(name = "status", nullable = false, unique = true)
    private VisitStatus status;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

    @Transient
    private String qrCodeBase64;
}
