package edu.practice.databaseconnection.controller;

import edu.practice.databaseconnection.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apikeys")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<String> generateApiKey(@RequestParam String client) {
        String apiKey = apiKeyService.generateApiKeyFor(client);
        return ResponseEntity.ok(apiKey);
    }
}
