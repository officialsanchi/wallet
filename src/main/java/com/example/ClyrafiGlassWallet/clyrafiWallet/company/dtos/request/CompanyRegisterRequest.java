package com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyRegisterRequest {
//
//    private String companyName;
//
//    public String getCompanyEmail() {
//        return companyEmail;
//    }
//
//    public void setCompanyEmail(String companyEmail) {
//        this.companyEmail = companyEmail;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getNatureOfBusiness() {
//        return natureOfBusiness;
//    }
//
//    public void setNatureOfBusiness(String natureOfBusiness) {
//        this.natureOfBusiness = natureOfBusiness;
//    }
//
//    public String getCompanyWebsite() {
//        return companyWebsite;
//    }
//
//    public void setCompanyWebsite(String companyWebsite) {
//        this.companyWebsite = companyWebsite;
//    }
//
//    public Admin getAdmin() {
//        return admin;
//    }
//
//    public void setAdmin(Admin admin) {
//        this.admin = admin;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    private String companyName;
    private String companyEmail;
    private String password;
    private String natureOfBusiness;
    private String companyWebsite;
    private UUID adminId;

//    private Admin admin;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
}
