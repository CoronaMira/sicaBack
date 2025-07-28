package edu.practice.sica.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import edu.practice.sica.entity.Visit;
import edu.practice.sica.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
                .peek(visit ->
                        visit.setQrCodeBase64(
                                qrToBase64(visit.getQrFolio())))
                .collect(Collectors.toList());
    }


    public Optional<Visit> findById(Long id) {
        return visitRepository.findById(id).map( visit -> {
            visit.setQrCodeBase64(qrToBase64(visit.getQrFolio()));
            return visit;
        });
    }


    public Optional<Visit> findByQrFolio(String qrFolio) {
        return visitRepository.findByQrFolio(qrFolio);
    }

    public Visit create(Visit visit) {
        visit.setQrFolio(UUID.randomUUID().toString());

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

}
