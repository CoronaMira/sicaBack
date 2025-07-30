package edu.practice.sica;

import com.zkteco.biometric.SicaEnrollmentTool;
import edu.practice.sica.service.FingerprintService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class    SicaApplication {
    public static void main(String[] args) {
       // SpringApplication.run(SicaApplication.class, args);
        // 1. Se utiliza SpringApplicationBuilder para configurar la aplicación
        //    antes de lanzarla.
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SicaApplication.class)
                .headless(false)  // 2. MUY IMPORTANTE: Permite que Java AWT/Swing se inicien.
                .run(args);       // 3. Inicia Spring y crea todos los beans (Services, Repositories, etc.).

        // 4. Una vez que Spring ha arrancado, le pedimos el bean del servicio que necesitamos.
        FingerprintService fingerprintService = context.getBean(FingerprintService.class);

        // 5. Usamos SwingUtilities.invokeLater para lanzar la interfaz gráfica de forma segura
        //    en el hilo de despacho de eventos (Event Dispatch Thread).
        SwingUtilities.invokeLater(() -> {
            // 6. Creamos una instancia de nuestra herramienta y le pasamos el servicio
            //    que obtuvimos de Spring.
            new SicaEnrollmentTool(fingerprintService);
        });
    }
}



