package com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CompanyVerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    public String getToken() {
//        return token;
//    }
//
//    public void setToken(String token) {
//        this.token = token;
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
//    }
//
//    public LocalDateTime getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(LocalDateTime expiryDate) {
//        this.expiryDate = expiryDate;
//    }

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    private LocalDateTime expiryDate;
}
