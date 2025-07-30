package edu.practice.sica.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import edu.practice.sica.entity.Visit;
import edu.practice.sica.entity.enums.VisitStatus;
import edu.practice.sica.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> findAll() {
        return visitRepository.findAll().stream()
                .map(this::enrichVisit)
                .collect(Collectors.toList());
    }


    public Optional<Visit> findById(Long id) {
        return visitRepository.findById(id)
                .map(this::enrichVisit);
    }
    public List<Visit> findByStatus(VisitStatus visitStatus) {
        return visitRepository.findByStatus(visitStatus).stream()
                .map(this::enrichVisit)
                .collect(Collectors.toList());
    }
    public List<Visit> findByName(String name) {
        return visitRepository.findByName(name).stream()
                .map(this::enrichVisit)
                .collect(Collectors.toList());
    }
    public List<Visit> findByDate(LocalDateTime startDate,LocalDateTime endDate ) {
        return visitRepository.findByDate(startDate,endDate ).stream()
                .map(this::enrichVisit)
                .collect(Collectors.toList());
    }


    public Optional<Visit> findByQrFolio(String qrFolio) {
        return visitRepository.findByQrFolio(qrFolio).map(this::enrichVisit);
    }

    public Visit create(Visit visit) {
        try {
            String qrCodeBase64 = generateQRCodeImage(visit.getQrFolio(), 250, 250);
            visit.setQrCodeBase64(qrCodeBase64);
        } catch (WriterException | IOException e) {
            log.error("Error al generar el código QR", e);
            throw new RuntimeException("No se pudo generar el código QR para el folio: " + visit.getQrFolio(), e);
        }

        long visitId = visitRepository.save(visit);
        visit.setId(visitId);

        return visit;
    }

    public Visit update(Long id, Visit updatedVisit) {
        return visitRepository.findById(id)
                .map(existingVisit -> {
                    updatedVisit.setId(id);
                    visitRepository.update(id, updatedVisit);
                    return updatedVisit;
                })
                .orElseThrow(() -> new RuntimeException("Visit not found with id: " + id));
    }

    public void deleteById(Long id) {
        visitRepository.findById(id).orElseThrow(() -> new RuntimeException("Visit not found with id: " + id));
        visitRepository.delete(id);
    }

    private String generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return Base64.getEncoder().encodeToString(pngData);
    }


    private String qrToBase64(String qrFolio){
        try {
            return  generateQRCodeImage( qrFolio, 250, 250);

        } catch (WriterException | IOException e) {

            log.error("Error al generar el código QR para el folio: {}",  qrFolio, e);
            return "";
        }

    }
    private String photoToBase64(String photoUrl) {
        if (photoUrl == null || photoUrl.trim().isEmpty()) {
            return null; // O un string vacío "" si lo prefieres
        }
        try {
            Path photoPath = Paths.get(photoUrl);
            if (Files.exists(photoPath)) {
                byte[] photoBytes = Files.readAllBytes(photoPath);
                return Base64.getEncoder().encodeToString(photoBytes);
            }
        } catch (IOException e) {
            log.error("Error al leer la imagen de la ruta: {}", photoUrl, e);
        }
        return null; // Devuelve null si el archivo no existe o hay un error
    }
    private Visit enrichVisit(Visit visit) {
        visit.setQrCodeBase64(qrToBase64(visit.getQrFolio()));
        visit.setVisitorPhotoBase64(photoToBase64(visit.getVisitorPhotoUrl()));
        return visit;
    }

}
