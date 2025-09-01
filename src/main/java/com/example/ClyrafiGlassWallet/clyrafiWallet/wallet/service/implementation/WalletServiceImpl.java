package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.implementation;


import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.model.EndUser;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository.WalletRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.interfaces.WalletService;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

@Service

public class WalletServiceImpl  implements WalletService {
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    private final WalletRepository walletRepository;
    @Override
    public Wallet createWallet(Company company, CurrencyType currency) {
        walletRepository.findByCompanyIdAndCurrency(company.getId(), currency)
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Wallet already exists for " + currency);
                });
        Wallet wallet = new Wallet();
        wallet.setCompany( company );
        wallet.setCurrency(currency);
        wallet.setBalance(0.0);

        return walletRepository.save(wallet);
    }

    @Override
    public void createDefaultWalletsForCompany(Company company) {
        EnumSet.of(CurrencyType.NGN, CurrencyType.USD, CurrencyType.SUI).forEach( currency -> {
            walletRepository.findByCompanyIdAndCurrency(company.getId(), currency)
                    .orElseGet(() -> createWallet(company, currency));
        });

    }

    @Override
    public Optional<Wallet> getCompanyWallets(UUID companyId) {
        return walletRepository.findByCompanyId(companyId);
    }

//    @Override
//    public Wallet createWalletForUser(Company company, EndUser user) {
//        Wallet wallet = new Wallet();
////        wallet.setCompany(company);
////        wallet.setEndUserId( user.getEndUserId() );
////        wallet.setCurrency(CurrencyType.NGN);
////        wallet.setBalance(0.0);
////        wallet.setWalletAddress( String.valueOf( UUID.fromString( UUID.randomUUID().toString() ) ) );
//
//        return walletRepository.save(wallet);
//    }
}
