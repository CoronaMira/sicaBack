package edu.practice.sica.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TardinessDto {
    private Long personId;
    private LocalDateTime arrivalTime;
}
