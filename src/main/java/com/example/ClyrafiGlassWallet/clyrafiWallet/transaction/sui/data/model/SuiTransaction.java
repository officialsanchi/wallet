//package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.sui.data.model;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionStatus;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionType;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class SuiTransaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//    @ManyToOne
//    private Company companyId;
//    @ManyToOne
//    private Wallet walletId;
//    private TransactionType type;
//    private long amountMinor;
//    private TransactionStatus status;
//    private String reference;
//    private String providerRef;
//    private String metadata;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//}
