package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.interfaces;

import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model.FiatTransaction;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatDepositRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatWithdrawRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatDepositResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatP2PResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatWithdrawResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface FiatTransactionService {
    FiatDepositResponse deposit(FiatDepositRequest fiatDepositRequest);
    FiatP2PResponse p2pTransfer(String senderCompanyId, String receiverCompanyId, long amountMinor, String reference);
    FiatWithdrawResponse withdraw(FiatWithdrawRequest fiatWithdrawRequest);
}
