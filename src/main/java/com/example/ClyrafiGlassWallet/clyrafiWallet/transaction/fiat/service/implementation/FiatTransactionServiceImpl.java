//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.implementation;
//
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionStatus;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionType;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model.FiatTransaction;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.repository.FiatTransactionRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatDepositRequest;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.interfaces.FiatTransactionService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository.WalletRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class FiatTransactionServiceImpl implements FiatTransactionService {
//    private final FiatTransactionRepository transactionRepository;
//    private final WalletRepository walletRepository;
//    private final PaystackService paystackService;
//
//
//    @Transactional
//    public String deposit(FiatDepositRequest fiatDepositRequest, String email, String reference, long amount) {
//        Wallet wallet = walletRepository.findByCompanyId(fiatDepositRequest.getCompanyId())
//                .orElseThrow(() -> new RuntimeException("Wallet not found"));
//
//
//        FiatTransaction txn = FiatTransaction.builder()
//                .walletId(wallet)
//                .receiverAccountNumber( fiatDepositRequest.getAccountNumber() )
//                .type(TransactionType.DEPOSIT)
//                .amount(amount)
//                .bankCode( fiatDepositRequest.getBankCode() )
//                .status(TransactionStatus.PENDING)
//                .reference(reference)
//                .email( email )
//                .build();
//        transactionRepository.save(txn);
//        return paystackService.initializeDeposit( amount,email, reference);
//    }
//
//    @Transactional
//    public FiatTransaction withdraw(UUID companyId, String accountNumber, String bankCode, long amountMinor, String reference) {
//        Wallet wallet = walletRepository.findByCompanyId(companyId)
//                .orElseThrow(() -> new RuntimeException("Wallet not found"));
//
//        if (wallet.getBalance() < amountMinor) {
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        FiatTransaction txn = FiatTransaction.builder()
//
//                .walletId(wallet.getId())
//                .type(TransactionType.WITHDRAW)
//                .amountMinor(amountMinor)
//                .accountNumber( accountNumber  )
//                .bankCode(bankCode)
//                .status(TransactionStatus.PENDING)
//                .reference(reference)
//                .build();
//        transactionRepository.save(txn);
//
////        boolean sent = paystackService.initializeDeposit(amountMinor, reference);
////
////        if (sent) {
////            wallet.setBalance(wallet.getBalance() - amountMinor);
////            walletRepository.save(wallet);
////            txn.setStatus(TransactionStatus.SUCCESS);
////        } else {
////            txn.setStatus(TransactionStatus.FAILED);
////        }
//
//        return transactionRepository.save(txn);
//    }
//
//
//    @Override
//    public String deposit(FiatDepositRequest fiatDepositRequest, String email, String reference, Long amount) {
//        return "";
//    }
//
//    @Transactional
//    public FiatTransaction p2pTransfer(String senderCompanyId, String receiverCompanyId, long amountMinor, String reference) {
//        Wallet senderWallet = walletRepository.findByCompanyId( UUID.fromString( senderCompanyId ) )
//                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));
//        Wallet receiverWallet = walletRepository.findByCompanyId( UUID.fromString( receiverCompanyId ) )
//                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));
//
//        if (senderWallet.getBalance() < amountMinor) {
//            throw new RuntimeException("Insufficient funds");
//        }
//
//        FiatTransaction txn = FiatTransaction.builder()
////                .senderAccountNumber( senderWallet.getWalletAddress()  )
////                .receiverAccountNumber( receiverWallet.getWalletAddress() )
////                .walletId(senderWallet.getId())
////                .type(TransactionType.TRANSFER)
////                .amountMinor(amountMinor)
////                .status(TransactionStatus.SUCCESS)
////                .reference(reference)
//                .build();
//
//        senderWallet.setBalance(senderWallet.getBalance() - amountMinor);
//        receiverWallet.setBalance(receiverWallet.getBalance()+ amountMinor);
//
//        walletRepository.save(senderWallet);
//        walletRepository.save(receiverWallet);
//        return transactionRepository.save(txn);
//    }
//    }
//
