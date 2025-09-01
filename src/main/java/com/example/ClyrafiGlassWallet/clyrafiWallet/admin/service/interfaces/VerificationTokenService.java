package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;

public interface VerificationTokenService {
    String generateToken(Admin admin);
    VerificationToken validateToken(String token, String email);
}
