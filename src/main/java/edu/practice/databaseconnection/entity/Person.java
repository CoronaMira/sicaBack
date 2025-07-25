package edu.practice.databaseconnection.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String type;

    private String enrollment;

    private String degree;

    private String shift;
}
