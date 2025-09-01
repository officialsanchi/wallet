//package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.implementation;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository.WalletAddressMappingRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class WalletResolverService {
//
//    private final WalletAddressMappingRepository mappingRepository;
//
//    public Wallet resolveWallet(String identifier) {
//        return mappingRepository.findByEmail(identifier)
//                .or(() -> mappingRepository.findByPhoneNumber(identifier))
//                .or(() -> mappingRepository.findByWalletAddress(identifier))
//                .map(WalletMapping::getWallet)
//                .orElseThrow(() -> new RuntimeException("No wallet found for identifier: " + identifier));
//    }
//}
