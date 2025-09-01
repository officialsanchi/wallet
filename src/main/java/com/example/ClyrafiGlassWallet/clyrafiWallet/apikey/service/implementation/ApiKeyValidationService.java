//package com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.service.implementation;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.data.model.ApiKey;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.data.repository.ApiKeyRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiKeyEnum;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiScopes;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import lombok.RequiredArgsConstructor;
////import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//
//public class ApiKeyValidationService {
//    public ApiKeyValidationService(ApiKeyRepository apiKeyRepository) {
//        this.apiKeyRepository = apiKeyRepository;
//    }
//
//    private final ApiKeyRepository apiKeyRepository;
//
//    public boolean validateApiKey(String rawKey, ApiScopes requiredScope) {
//        if (rawKey == null || rawKey.isBlank()) {
//            return false;
//        }
////
////
////        String keyId = rawKey.substring(0, Math.min(10, rawKey.length()));
////
////        Optional<ApiKey> apiKeyOpt = apiKeyRepository.findByCompanyAndKeyId(  );
////
////        if (apiKeyOpt.isEmpty()) return false;
////
////        ApiKey apiKey = apiKeyOpt.get();
////
////
////        boolean matches = BCrypt.checkpw(rawKey, apiKey.getKeyHash());
////        if (!matches) return false;
////
////
////        if (apiKey.getApiKeyEnum() != ApiKeyEnum.ACTIVE) return false;
////
////
////        return apiKey.getScopes().equals(requiredScope);
//       return true;
//    }
//
//
//}
