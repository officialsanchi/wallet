package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.controller;

import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model.FiatTransaction;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatDepositRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatWithdrawRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.P2PTransferRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatDepositResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatP2PResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatWithdrawResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.interfaces.FiatTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/fiat")
@RequiredArgsConstructor
public class FiatTransactionController {

    private final FiatTransactionService fiatTransactionService;

    @PostMapping("/deposit")
    public ResponseEntity<FiatDepositResponse> deposit(

            @RequestParam FiatDepositRequest fiatDepositRequest
//            @RequestParam UUID companyId,
//            @RequestParam String email,
//            @RequestParam long amountMinor,
//            @RequestParam String reference
    ) {
        FiatDepositResponse initUrl = fiatTransactionService.deposit( fiatDepositRequest  );
        return ResponseEntity.ok(initUrl);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<FiatWithdrawResponse> withdraw(

            FiatWithdrawRequest fiatWithdrawRequest
//            @RequestParam UUID companyId,
//            @RequestParam String accountNumber,
//            @RequestParam String bankCode,
//            @RequestParam long amountMinor,
//            @RequestParam String reference
    ) {
       FiatWithdrawResponse txn = fiatTransactionService.withdraw(fiatWithdrawRequest);
        return ResponseEntity.ok(txn);
    }

    @PostMapping("/p2p-transfer")
    public ResponseEntity<FiatP2PResponse> p2pTransfer(

            @RequestParam UUID senderCompanyId,
            @RequestParam UUID receiverCompanyId,
            @RequestParam long amountMinor,
            @RequestParam String reference
    ) {
        FiatP2PResponse txn = fiatTransactionService.p2pTransfer(senderCompanyId.toString(),receiverCompanyId.toString(),amountMinor,reference );
        return ResponseEntity.ok(txn);
    }
}
