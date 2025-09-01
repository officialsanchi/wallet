package com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.CompanyVerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyVerificationTokenRepository extends JpaRepository<CompanyVerificationToken, UUID> {
    Optional<CompanyVerificationToken> findByToken(String token);
}
