package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.request.AdminRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.responses.AdminRegisterResponses;
import org.springframework.stereotype.Component;

//@Component
public interface AdminService {
    AdminRegisterResponses registerAdmin(AdminRegisterRequest adminRegisterRequest);
    String resendVerificationEmail(String email);
    VerificationToken validateToken(String token, String email);
}
