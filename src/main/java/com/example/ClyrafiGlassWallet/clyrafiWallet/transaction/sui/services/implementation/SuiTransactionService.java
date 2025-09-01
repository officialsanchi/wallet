//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.services.implementation;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.P2PTransferRequest;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionStatus;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionType;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.data.model.SuiTransaction;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.data.repository.SuiTransactionRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.services.interfaces.TransactionServiceSui;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class SuiTransactionService implements TransactionServiceSui {
//    private final RestTemplate restTemplate;
//   private final SuiTransactionRepository suiTransactionRepository;
//
//    @Transactional
//    public void p2pFiatTransfer(P2PTransferRequest p2PTransferRequest) {
////        if (senderWallet.getBalance() < amountMinor) {
////            throw new IllegalArgumentException("Insufficient balance");
////        }
//
////        p2PTransferRequest.setBalance(p2PTransferRequest.getBalance() - amountMinor);
////        receiverWallet.setBalance(receiverWallet.getBalance() + amountMinor);
//
//        SuiTransaction debit = new SuiTransaction();
//        debit.setId(UUID.randomUUID());
////        debit.setCompanyId(senderWallet.getCompanyId());
////        debit.setWalletId(senderWallet);
//        debit.setType( TransactionType.WITHDRAW);
////        debit.setAmountMinor(amountMinor);
//        debit.setStatus( TransactionStatus.SUCCESS);
//        debit.setReference( UUID.randomUUID().toString());
//        debit.setCreatedAt( LocalDateTime.now());
//
//        SuiTransaction credit = new SuiTransaction();
//        credit.setId(UUID.randomUUID());
////        credit.setCompanyId(receiverWallet.getCompanyId());
////        credit.setWalletId(receiverWallet);
//        credit.setType(TransactionType.DEPOSIT);
////        credit.setAmountMinor(amountMinor);
//        credit.setStatus(TransactionStatus.SUCCESS);
//        credit.setReference(UUID.randomUUID().toString());
//        credit.setCreatedAt(LocalDateTime.now());
//
//        suiTransactionRepository.save(debit);
//        suiTransactionRepository.save(credit);
//    }
//
//    @Override
//    public String withdrawSui(String walletAddress, double amount) {
//        String url = "https://glass-wallet-listener.onrender.com/api/withdrawSuiCoin";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType( MediaType.APPLICATION_JSON);
//
//        Map<String, Object> body = new HashMap<>();
////        body.put("walletAddress", walletAddress);
////        body.put("amount", amount);
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
//
//        if (response.getBody() != null && (Boolean) response.getBody().get("success")) {
//            return (String) response.getBody().get("txHash");
//        }
//        throw new RuntimeException("SUI withdrawal failed");
//    }
//}
