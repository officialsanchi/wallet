package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.WalletAddressMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


public interface WalletAddressMappingRepository extends JpaRepository<WalletAddressMapping, UUID> {
    Optional<WalletAddressMapping> findByEmail(String email);
    Optional<WalletAddressMapping> findByPhoneNumber(String phoneNumber);
    Optional<WalletAddressMapping> findByWalletAddress(String walletAddress);
}
