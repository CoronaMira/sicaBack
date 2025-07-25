package edu.practice.databaseconnection.service;

import edu.practice.databaseconnection.repository.ApiKeyRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApiKeyService {

    private final ApiKeyRepository repository;

    public ApiKeyService(ApiKeyRepository repository) {
        this.repository = repository;
    }

    public String generateApiKeyFor(String clientName) {
        String apiKey = UUID.randomUUID().toString();
        repository.save(clientName, apiKey);
        return apiKey;
    }

    public boolean isValid(String apiKey) {
        return repository.findByApiKeyAndActiveTrue(apiKey).isPresent();
    }
}
