package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model;

import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.dtos.responses.WalletResponse;

public class WalletMapper {
    public static WalletResponse toResponse(Wallet wallet) {
        return WalletResponse.builder()
                .walletId(wallet.getId())
                .companyId(wallet.getCompany().getId())
                .currency( String.valueOf( wallet.getCurrency() ) )
                .balance(wallet.getBalance())
                .build();
    }

    public static WalletResponse toMappingResponse(WalletAddressMapping mapping) {
        Wallet wallet = mapping.getWallet();
        return WalletResponse.builder()
                .mappingId(mapping.getId())
                .email(mapping.getEmail())
                .phoneNumber(mapping.getPhoneNumber())
                .walletAddress(mapping.getWalletAddress())
                .walletId(wallet.getId())
                .companyId(wallet.getCompany().getId())
                .currency(wallet.getCurrency().name())
                .balance(wallet.getBalance())
                .build();
    }
}
