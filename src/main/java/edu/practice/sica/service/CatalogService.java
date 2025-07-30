package edu.practice.sica.service;

import edu.practice.sica.entity.Catalog;
import edu.practice.sica.entity.Visit;
import edu.practice.sica.entity.enums.CatalogEnum;
import edu.practice.sica.repository.CatalogRepository;
import edu.practice.sica.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }
    public List<Catalog> findAll(CatalogEnum catalogEnum) {
        return catalogRepository.findByType(catalogEnum);

    }




}
