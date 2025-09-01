//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.controller;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.P2PTransferRequest;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.services.implementation.SuiTransactionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/sui")
//@RequiredArgsConstructor
//public class SuiTransactionController {
//    private final SuiTransactionService suiTransactionService;
//
//
//    @PostMapping("/p2p-transfer")
//    public ResponseEntity<String> p2pTransfer(@RequestBody P2PTransferRequest request) {
//        suiTransactionService.p2pFiatTransfer(request);
//        return ResponseEntity.ok("P2P transfer successful");
//    }
//
//    @PostMapping("/withdraw")
//    public ResponseEntity<String> withdrawSui(
//            @RequestParam String walletAddress,
//            @RequestParam double amount
//    ) {
//        String txHash = suiTransactionService.withdrawSui(walletAddress, amount);
//        return ResponseEntity.ok("Withdrawal successful, TxHash: " + txHash);
//    }
//}
