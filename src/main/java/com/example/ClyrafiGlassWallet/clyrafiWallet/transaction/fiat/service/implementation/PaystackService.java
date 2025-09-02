package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class PaystackService {
    private final RestTemplate restTemplate ;
    @Value("${paystack.secret.key}")
    private String secretKey;
    @Value("${paystack.base.url}")
    private String baseUrl;

    public String initializeDeposit(Long amountMinor, String email, String reference) {

        long amountNaira = amountMinor;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(secretKey);
        headers.setContentType( MediaType.APPLICATION_JSON);

        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amountNaira);
        payload.put("email", email);
        payload.put("reference", reference);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<Map> response =
                restTemplate.postForEntity("https://api.paystack.co/transaction/initialize", entity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ((Map<String, String>) response.getBody().get("data")).get("reference");
        }
        throw new RuntimeException("Failed to initialize Payment deposit");

    }

    public boolean verifyTransaction(String reference) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(secretKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response =
                restTemplate.exchange("https://api.paystack.co/transaction/verify/" + reference,
                        HttpMethod.GET, entity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String status = (String) ((Map) response.getBody().get("data")).get("status");
            return "success".equalsIgnoreCase(status);
        }
        return false;
    }

    public String initializeWithdrawal(Long amountMinor, String accountNumber, String bankCode) {
        long amountNaira = amountMinor;
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(secretKey);
        headers.setContentType( MediaType.APPLICATION_JSON);
        Map<String, Object> payload = new HashMap<>();
        payload.put("amount", amountNaira);
        payload.put("email", accountNumber);
        payload.put("reference", bankCode);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<Map> response =
                restTemplate.postForEntity(" https://api.paystack.co/transferrecipient", entity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ((Map<String, String>) response.getBody().get("data")).get("reference");
        }
        throw new RuntimeException("Failed to initialize Payment deposit");

    }

    public String transferToBank(Long amountMinor, String accountNumber, String bankCode) {

        return UUID.randomUUID().toString();
    }

}
