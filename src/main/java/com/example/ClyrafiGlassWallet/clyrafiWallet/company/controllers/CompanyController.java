package com.example.ClyrafiGlassWallet.clyrafiWallet.company.controllers;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses.CompanyRegisterResponses;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.service.interfaces.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")

public class CompanyController {
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    private final CompanyService companyService;



    @PostMapping("/register")
    public ResponseEntity<CompanyRegisterResponses> registerCompany(@RequestBody CompanyRegisterRequest request) {
        return ResponseEntity.ok(companyService.companyRegister(request));
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyCompany(@RequestParam("token") String token) {
        return ResponseEntity.ok(companyService.verifyCompany(token));
    }
    @PostMapping("/resend-verification")
    public ResponseEntity<String> resendVerification(@RequestParam String email) {
        return ResponseEntity.ok(companyService.resendVerificationEmail(email));
    }
}
