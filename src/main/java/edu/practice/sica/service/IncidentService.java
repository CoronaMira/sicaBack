package edu.practice.sica.service;

import edu.practice.sica.entity.AbsenceDto;
import edu.practice.sica.entity.IncidentsSummary;
import edu.practice.sica.entity.TardinessDto;
import edu.practice.sica.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }


    public IncidentsSummary getIncidents(Long personId, LocalDate startDate, LocalDate endDate, LocalTime lateThresholdTime) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        List<AbsenceDto> absences = incidentRepository.findAbsencesByPersonAndDateRange(personId, startDate, endDate);
        List<TardinessDto> tardinessRecords = incidentRepository.findTardinessByPersonAndDateRange(personId, startDate, endDate, lateThresholdTime);

        return IncidentsSummary.builder().absences(absences).tardinessRecords(tardinessRecords).build();
    }

    public List<AbsenceDto> getAbsences(Long personId, LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        return incidentRepository.findAbsencesByPersonAndDateRange(personId, startDate, endDate);
    }

    public List<TardinessDto> getTardinessRecords(Long personId, LocalDate startDate, LocalDate endDate, LocalTime lateThresholdTime) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        return incidentRepository.findTardinessByPersonAndDateRange(personId, startDate, endDate, lateThresholdTime);
    }
}
