package com.example.chatbot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.chatbot.dto.ChatResponse;

@Service
public class AiService {

    @Value("${gemini.api.url}")
    private String geminiUrl;

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public ChatResponse generateResponse(String prompt) {

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of(
                                "role", "user",
                                "parts", List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        String url = geminiUrl + "?key=" + apiKey;

        try {
            Map<String, Object> response
                    = restTemplate.postForObject(url, entity, Map.class);

            List<Map<String, Object>> candidates
                    = (List<Map<String, Object>>) response.get("candidates");

            Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");

            List<Map<String, Object>> parts
                    = (List<Map<String, Object>>) content.get("parts");

            String text = (String) parts.get(0).get("text");

            return new ChatResponse(text);

        } catch (HttpServerErrorException e) {

            if (e.getStatusCode().value() == 503) {
                return new ChatResponse("⚠️ Gemini servers are overloaded. Please try again in a few seconds.");
            }

            return new ChatResponse("Server Error: " + e.getMessage());

        } catch (Exception e) {
            return new ChatResponse("Error reading response: " + e.getMessage());
        }
    }
}
