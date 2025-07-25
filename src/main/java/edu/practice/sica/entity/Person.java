package edu.practice.sica.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "type")
    private String type;

    @Column(name = "enrollment")
    private String enrollment;

    @Column(name = "degree")
    private String degree;

    @Column(name = "shift")
    private String shift;
}
