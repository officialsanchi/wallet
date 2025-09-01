package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.controller;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.WalletMapper;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.dtos.responses.WalletResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.interfaces.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;
    private final CompanyRepository companyRepository;

    @PostMapping("/{companyId}/create")
    public ResponseEntity<WalletResponse> createWallet(
            @PathVariable UUID companyId,
            @RequestParam CurrencyType currency) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        Wallet wallet = walletService.createWallet(company, currency);
        return ResponseEntity.ok(WalletMapper.toResponse(wallet));
    }

    @PostMapping("/{companyId}/create-default")
    public ResponseEntity<String> createDefaultWallets(@PathVariable UUID companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        walletService.createDefaultWalletsForCompany(company);
        return ResponseEntity.ok("Default wallets created for company " + company.getCompanyName());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<List<WalletResponse>> getCompanyWallets(@PathVariable UUID companyId) {
        List<WalletResponse> responses = walletService.getCompanyWallets(companyId).stream()
                .map( WalletMapper::toResponse)
                .collect( Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
