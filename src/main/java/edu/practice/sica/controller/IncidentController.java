package edu.practice.sica.controller;

import edu.practice.sica.entity.AbsenceDto;
import edu.practice.sica.entity.IncidentsSummary;
import edu.practice.sica.entity.TardinessDto;
import edu.practice.sica.service.IncidentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/summary/person/{personId}")
    public ResponseEntity<IncidentsSummary> getIncidentsSummary(
            @PathVariable Long personId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        IncidentsSummary summary = incidentService.getIncidents(personId, startDate, endDate);
        return ResponseEntity.ok(summary);
    }


    @GetMapping("/absences/person/{personId}")
    public ResponseEntity<List<AbsenceDto>> getAbsences(
            @PathVariable Long personId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<AbsenceDto> absences = incidentService.getAbsences(personId, startDate, endDate);
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/tardiness/person/{personId}")
    public ResponseEntity<List<TardinessDto>> getTardinessRecords(
            @PathVariable Long personId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<TardinessDto> tardinessRecords = incidentService.getTardinessRecords(personId, startDate, endDate);
        return ResponseEntity.ok(tardinessRecords);
    }
}
