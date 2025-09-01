package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {
    Optional<VerificationToken> findByTokenAndAdminEmail(String token, String email);
    Optional<VerificationToken> findByAdminId(UUID adminId);
    void deleteAllByAdminId(UUID adminId);
//    Optional<VerificationToken> findByToken(String token);
//    Optional<VerificationToken> findByAdmin(Admin admin);
}
