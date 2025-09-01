package com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyCategory;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company", nullable = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyType currency;

    @Column(nullable = false)
    private double balance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    private String walletAddress;
    private String endUserId;

    @PrePersist
    public void onCreate() {
        this.balance = 0.0;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
