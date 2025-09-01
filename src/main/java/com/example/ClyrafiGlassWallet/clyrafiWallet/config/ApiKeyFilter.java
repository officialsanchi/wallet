//package com.example.ClyrafiGlassWallet.clyrafiWallet.config;
//
////import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.enums.ApiScopes;
////import com.example.ClyrafiGlassWallet.clyrafiWallet.apikey.service.implementation.ApiKeyValidationService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//
//@Component
//
//public class ApiKeyFilter extends OncePerRequestFilter {
//    public ApiKeyFilter(ApiKeyValidationService apiKeyValidationService) {
//        this.apiKeyValidationService = apiKeyValidationService;
//    }
//
//    private final ApiKeyValidationService apiKeyValidationService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        String apiKey = request.getHeader("X-API-KEY");
//
//
//        ApiScopes requiredScope = request.getRequestURI().startsWith("/api/transactions")
//                ? ApiScopes.WALLET_WRITE
//                : ApiScopes.WALLET_READ;
//
//        if (apiKey == null || !apiKeyValidationService.validateApiKey(apiKey, requiredScope)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write("Invalid or missing API Key");
//            return;
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
