//package com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.service.implementation;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.data.model.ApiKey;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.data.repository.ApiKeyRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiKeyEnum;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiScopes;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.service.interfaces.ApiKeyService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import lombok.RequiredArgsConstructor;
////import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//import java.security.SecureRandom;
//import java.time.LocalDateTime;
//import java.util.Base64;
//
//@Service
//
//public class ApiKeyServiceImpl implements ApiKeyService {
//    public ApiKeyServiceImpl(ApiKeyRepository apiKeyRepository) {
//        this.apiKeyRepository = apiKeyRepository;
//    }
//
//    private final ApiKeyRepository apiKeyRepository;
//
//
//    @Override
//    public String generateSandboxKey(Company company, ApiScopes scopes) {
//        String rawKey = "sandbox_" + generateSecureToken();
//
//
////        String keyHash = BCrypt.hashpw(rawKey, BCrypt.gensalt());
//        String keyHash = "";
//
//        ApiKey apiKey = new ApiKey();
//                apiKey.setCompany( company );
//        apiKey.setKeyId(rawKey.substring( 0, 10 ));
//              apiKey.setLastUsedAt(LocalDateTime.now());
//        apiKey.setKeyHash(keyHash);
//        apiKey.setScopes(scopes);
//        apiKey.setApiKeyEnum(ApiKeyEnum.ACTIVE);
//        apiKey.setCreatedAt(LocalDateTime.now());
//        apiKeyRepository.save(apiKey);
//
//
//        return rawKey;
//
//    }
//    private String generateSecureToken() {
//        SecureRandom secureRandom = new SecureRandom();
//        byte[] bytes = new byte[32];
//        secureRandom.nextBytes(bytes);
//        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
//    }
//}
