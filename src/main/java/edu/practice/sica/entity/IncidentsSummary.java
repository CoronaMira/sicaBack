package edu.practice.sica.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IncidentsSummary {

    private List<AbsenceDto> absences;
    private List<TardinessDto> tardinessRecords;

}
