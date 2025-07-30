package edu.practice.sica.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.sica.entity.Visit;
import edu.practice.sica.entity.enums.VisitStatus;
import edu.practice.sica.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    private static final Logger log = LoggerFactory.getLogger(VisitController.class);
    private final VisitService visitService;

    private final Path rootLocation = Paths.get("upload-dir");

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
        // Crea el directorio si no existe al iniciar el controlador
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }


    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<Visit> create(@RequestPart("visit") String visitJson,@RequestPart("photo") MultipartFile visitorPhotoFile) {
        try {
            log.info(visitJson);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules();
            Visit visit = objectMapper.readValue(visitJson, Visit.class);

            if (visitorPhotoFile.isEmpty()) {

                return ResponseEntity.badRequest().build();
            }

            // Genera un nombre de archivo único para evitar colisiones
            String originalFilename = visitorPhotoFile.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String qrFolio = UUID.randomUUID().toString();
            String uniqueFilename = qrFolio + extension;

            Path destinationFile = this.rootLocation.resolve(Paths.get(uniqueFilename)).toAbsolutePath();
            Files.copy(visitorPhotoFile.getInputStream(), destinationFile);

            visit.setVisitorPhotoUrl(destinationFile.toString());
            visit.setQrFolio(qrFolio);

            Visit createdVisit = visitService.create(visit);
            return ResponseEntity.ok(createdVisit);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visit> getById(@PathVariable Long id) {
        return visitService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> findVisits(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String qrFolio,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        long providedParamsCount = Stream.of(status, name, qrFolio)
                .filter(Objects::nonNull)
                .count();
        if (providedParamsCount > 1) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Solo se puede filtrar por un criterio a la vez.");
        }

        try {
            if (status != null) {
                VisitStatus visitStatus = VisitStatus.valueOf(status.toUpperCase());
                return ResponseEntity.ok(visitService.findByStatus(visitStatus));
            }
            if (name != null) {
                return ResponseEntity.ok(visitService.findByName(name));
            }
            if (qrFolio != null) {
                List<Visit> result = visitService.findByQrFolio(qrFolio)
                        .map(Collections::singletonList)
                        .orElse(Collections.emptyList());
                return ResponseEntity.ok(result);
            }
            if (startDate != null && endDate != null){
                String isoDateTimeString = "2025-07-28T10:30:00";

                List<Visit> result = visitService.findByDate(LocalDateTime.parse(startDate),LocalDateTime.parse(endDate));
                return ResponseEntity.ok(result);

            }
            return ResponseEntity.ok(visitService.findAll());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Error: El valor del status no es válido: " + status);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visit> update(@PathVariable Long id, @RequestBody Visit visit) {
        Visit updatedVisit = visitService.update(id, visit);
        return ResponseEntity.ok(updatedVisit);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        visitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
