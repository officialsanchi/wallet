package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model;

import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.dtos.responses.WalletResponse;

public class WalletMapper {
    public static WalletResponse toResponse(Wallet wallet) {
        return WalletResponse.builder()
                .walletId(wallet.getId())
                .companyId(wallet.getCompany().getId())
                .currency(wallet.getCurrency())
                .balance(wallet.getBalance())
                .build();
    }
}
