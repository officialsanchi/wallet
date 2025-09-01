package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums;

public enum CurrencyType {
    NGN(CurrencyCategory.FIAT),
    USD(CurrencyCategory.FIAT),
    SUI(CurrencyCategory.CRYPTO);

    private final CurrencyCategory category;

    CurrencyType(CurrencyCategory category) {
        this.category = category;
    }

    public CurrencyCategory getCategory() {
        return category;
    }
}
