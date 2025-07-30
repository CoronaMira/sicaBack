package edu.practice.sica.lector;

import com.zkteco.biometric.FingerprintCaptureListener;
import com.zkteco.biometric.FingerprintSensor;

import java.util.concurrent.CountDownLatch;

public class LectorZKTeco implements AutoCloseable {

    private final FingerprintSensor sensor;
    private boolean isConnected = false;
    private byte[] lastCapturedTemplate;
    private CountDownLatch countdownLatch;

    public LectorZKTeco() {
        this.sensor = new FingerprintSensor();
    }

    public boolean conectar() {
        if (0 != sensor.openDevice(0)) {
            System.err.println("Error: No se pudo abrir el dispositivo. Verifique la conexión.");
            return false;
        }

        // ----- INICIO DE CAMBIOS -----
        // AÑADIMOS ESTAS DOS LÍNEAS

        // 1. Desactivamos la función anti-dedos-falsos, que puede causar conflictos.
        // El valor 0 significa 'desactivar'.
        sensor.setFakeFunOn(0);
        System.out.println("-> Función Anti-Fake desactivada.");

        // 2. Esperamos un instante para que el hardware se estabilice.
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ----- FIN DE CAMBIOS -----

        FingerprintCaptureListener listener = new FingerprintCaptureListener() {
            @Override
            public void captureOK(byte[] image) {
                System.out.println("-> Imagen capturada, extrayendo plantilla...");
            }

            @Override
            public void captureError(int errCode) {
                System.err.println("Error de captura, código: " + errCode);
                countdownLatch.countDown();
            }

            @Override
            public void extractOK(byte[] template) {
                System.out.println("-> Plantilla extraída con éxito.");
                lastCapturedTemplate = template;
                countdownLatch.countDown();
            }
        };

        sensor.setFingerprintCaptureListener(listener);
        this.isConnected = true;
        System.out.println("Dispositivo conectado y listo para recibir huellas.");
        return true;
    }

    private byte[] esperarPorHuella() {
        lastCapturedTemplate = null;
        countdownLatch = new CountDownLatch(1);

        System.out.println("Por favor, coloque su dedo en el lector. El programa está esperando...");

        if (!sensor.startCapture()) {
            System.err.println("Error al iniciar el modo de captura continua.");
            return null;
        }

        try {
            // Detiene el hilo principal hasta que el listener llame a countDown().
            countdownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("La espera por la huella fue interrumpida.");
        } finally {
            // Detenemos la captura continua para ahorrar recursos.
            sensor.stopCapture();
        }

        return lastCapturedTemplate;
    }

    public int registrarHuella() {
        if (!isConnected) return -1;
        byte[] template = esperarPorHuella();
        if (template != null) {
            int fid = sensor.DBCount() + 1;
            if (0 == sensor.DBAdd(fid, template)) {
                System.out.println("¡Huella registrada con éxito! ID: " + fid);
                return fid;
            } else {
                System.err.println("Error al agregar la huella a la base de datos.");
            }
        }
        return -1;
    }

    public int identificarHuella() {
        if (!isConnected) return -1;
        byte[] template = esperarPorHuella();
        if (template != null) {
            int[] fid = new int[1];
            int[] score = new int[1];
            if (0 == sensor.IdentifyFP(template, fid, score)) {
                System.out.println("¡Huella identificada! ID: " + fid[0] + " (Puntuación: " + score[0] + ")");
                return fid[0];
            } else {
                System.out.println("Huella no encontrada en la base de datos.");
            }
        }
        return -1;
    }

    @Override
    public void close() {
        if (isConnected) {
            sensor.destroy();
            System.out.println("Recursos del lector liberados.");
        }
    }
}
