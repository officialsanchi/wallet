//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionStatus;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionType;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Getter
//@Setter
//@Builder
//@Entity
//@AllArgsConstructor
//public class FiatTransaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//    @ManyToOne
//    private Company companyId;
//    @ManyToOne
//    private Wallet walletId;
//    private TransactionType type;
//    private long amount;
//    private String email;
//    private TransactionStatus status;
//    private String reference;
//    private String providerRef;
//    private String metadata;
//    private  String accountNumber;
//    private String bankCode;
//    private String senderAccountNumber;
//    private String receiverAccountNumber;
//
//
//    public FiatTransaction() {
//
//    }
//}
