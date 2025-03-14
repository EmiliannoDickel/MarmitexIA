package dev.java10x.marmitaia.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OpenIAController {

    private final RestTemplate restTemplate;

    public OpenIAController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    @GetMapping("/gerar-marmita")
    public String gerarReceita(@RequestParam String tipo, @RequestParam List<String> ingredientes) {
        String mensagem = String.format(
                "Você é um chef de cozinha especializado em alimentação saudável. Crie uma receita para uma marmita %s usando os seguintes ingredientes: %s. " +
                        "A receita deve incluir: 1. Modo de preparo passo a passo 2. Informações nutricionais aproximadas 3. Dicas de armazenamento.",
                tipo, String.join(", ", ingredientes)
        );

        // Criação do JSON para a API
        String jsonPayload = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": [{\"role\": \"user\", \"content\": \"" + mensagem + "\"}]}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                OPENAI_URL,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response.getBody();
    }

}
