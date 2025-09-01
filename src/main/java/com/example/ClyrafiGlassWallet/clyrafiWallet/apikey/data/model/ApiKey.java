//package com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.data.model;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiKeyEnum;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiScopes;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Entity
//public class ApiKey {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    public Company getCompany() {
//        return company;
//    }
//
//    public void setCompany(Company company) {
//        this.company = company;
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
//    public String getKeyId() {
//        return keyId;
//    }
//
//    public void setKeyId(String keyId) {
//        this.keyId = keyId;
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
//    public LocalDateTime getLastUsedAt() {
//        return lastUsedAt;
//    }
//
//    public void setLastUsedAt(LocalDateTime lastUsedAt) {
//        this.lastUsedAt = lastUsedAt;
//    }
//
//    public String getKeyHash() {
//        return keyHash;
//    }
//
//    public void setKeyHash(String keyHash) {
//        this.keyHash = keyHash;
//    }
//
//    public ApiScopes getScopes() {
//        return scopes;
//    }
//
//    public void setScopes(ApiScopes scopes) {
//        this.scopes = scopes;
//    }
//
//    public ApiKeyEnum getApiKeyEnum() {
//        return apiKeyEnum;
//    }
//
//    public void setApiKeyEnum(ApiKeyEnum apiKeyEnum) {
//        this.apiKeyEnum = apiKeyEnum;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "company_id")
//    private Company company;
//    private String keyId;
//    private LocalDateTime createdAt;
//    private LocalDateTime lastUsedAt;
//    private String keyHash;
//    private ApiScopes scopes;
//    private ApiKeyEnum apiKeyEnum;
//
//    public ApiKey() {
//
//    }
//}
