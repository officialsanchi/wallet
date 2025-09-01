package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.interfaces;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.model.EndUser;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;

import java.util.Optional;
import java.util.UUID;

public interface WalletService {
    Wallet createWallet(Company company, CurrencyType currency);
    void createDefaultWalletsForCompany(Company company);
    Optional<Wallet> getCompanyWallets(UUID companyId);
//    Wallet createWalletForUser(Company company, EndUser user);
}
