package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findByCompanyIdAndCurrency(UUID companyId, CurrencyType currency);
    Optional<Wallet> findByCompanyId(UUID companyId);
}
