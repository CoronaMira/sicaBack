package edu.practice.sica.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AbsenceDto {
    private LocalDate date;
    private Long personId;
}
