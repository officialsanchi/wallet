package com.example.ClyrafiGlassWallet.clyrafiWallet.company.service.interfaces;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyLoginRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses.CompanyLoginResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses.CompanyRegisterResponses;
import org.springframework.stereotype.Component;

@Component
public interface CompanyService {
    CompanyRegisterResponses companyRegister(CompanyRegisterRequest companyRegisterRequest);
    String verifyCompany(String token);
    String resendVerificationEmail(String companyEmail);
    CompanyLoginResponse login(CompanyLoginRequest request);

}
