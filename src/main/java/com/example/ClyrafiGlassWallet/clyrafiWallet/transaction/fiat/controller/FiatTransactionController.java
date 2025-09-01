//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.controller;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model.FiatTransaction;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.interfaces.FiatTransactionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/fiat")
//@RequiredArgsConstructor
//public class FiatTransactionController {
//
//    private final FiatTransactionService fiatTransactionService;
//
//    @PostMapping("/deposit")
//    public ResponseEntity<String> deposit(
//            @RequestParam UUID companyId,
//            @RequestParam String email,
//            @RequestParam long amountMinor,
//            @RequestParam String reference
//    ) {
//        String initUrl = fiatTransactionService.deposit(companyId, email, amountMinor, reference);
//        return ResponseEntity.ok(initUrl);
//    }
//
//    @PostMapping("/withdraw")
//    public ResponseEntity<FiatTransaction> withdraw(
//            @RequestParam UUID companyId,
//            @RequestParam String accountNumber,
//            @RequestParam String bankCode,
//            @RequestParam long amountMinor,
//            @RequestParam String reference
//    ) {
//        FiatTransaction txn = fiatTransactionService.withdraw(companyId, accountNumber, bankCode, amountMinor, reference);
//        return ResponseEntity.ok(txn);
//    }
//
//    @PostMapping("/p2p-transfer")
//    public ResponseEntity<FiatTransaction> p2pTransfer(
//            @RequestParam UUID senderCompanyId,
//            @RequestParam UUID receiverCompanyId,
//            @RequestParam long amountMinor,
//            @RequestParam String reference
//    ) {
//        FiatTransaction txn = fiatTransactionService.p2pTransfer(senderCompanyId, receiverCompanyId, amountMinor, reference);
//        return ResponseEntity.ok(txn);
//    }
//}
