package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.dtos.responses;

import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {
    private UUID walletId;
    private UUID companyId;
    private CurrencyType currency;
    private double balance;
}
