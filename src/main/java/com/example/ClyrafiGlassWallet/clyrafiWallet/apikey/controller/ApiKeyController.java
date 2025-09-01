//package com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.controller;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiScopes;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.service.interfaces.ApiKeyService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/apikey")
//
//public class ApiKeyController {
//    public ApiKeyController(ApiKeyService apiKeyService, CompanyRepository companyRepository) {
//        this.apiKeyService = apiKeyService;
//        this.companyRepository = companyRepository;
//    }
//
//    private final ApiKeyService apiKeyService;
//    private final CompanyRepository companyRepository;
//
//    @PostMapping("/sandbox/{companyId}")
//    public ResponseEntity<String> generateSandboxKey(
//            @PathVariable UUID companyId,
//            @RequestParam ApiScopes scope) {
//
//        Company company = companyRepository.findById(companyId)
//                .orElseThrow(() -> new RuntimeException("Company not found"));
//
//        String sandboxKey = apiKeyService.generateSandboxKey(company, scope);
//
//        return ResponseEntity.ok("Sandbox API key: " + sandboxKey);
//    }
//}
