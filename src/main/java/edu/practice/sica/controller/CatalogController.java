package edu.practice.sica.controller;

import edu.practice.sica.entity.Catalog;
import edu.practice.sica.entity.Person;
import edu.practice.sica.entity.enums.CatalogEnum;
import edu.practice.sica.service.CatalogService;
import edu.practice.sica.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping ("/api/catalogs")
public class CatalogController {
    private static final Logger log = LoggerFactory.getLogger(CatalogController.class);
    private final CatalogService catalogService;

    public CatalogController (CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    @GetMapping
    public ResponseEntity<List<Catalog>> getAll(@RequestParam(required = true) String type,@RequestParam(required = false) String idFather) {
        List<Catalog> catalogs = catalogService.findAll(CatalogEnum.valueOf(type),idFather);
        return ResponseEntity.ok(catalogs);
    }

}
