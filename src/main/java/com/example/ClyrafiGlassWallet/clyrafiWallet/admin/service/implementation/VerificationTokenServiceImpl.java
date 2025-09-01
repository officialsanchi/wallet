package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.implementation;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.VerificationTokenRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class VerificationTokenServiceImpl implements VerificationTokenService {
    public VerificationTokenServiceImpl(VerificationTokenRepository verificationTokenRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
    }

    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public String generateToken(Admin admin) {

        String token = UUID.randomUUID().toString();

        VerificationToken verificationToken = new  VerificationToken();
                verificationToken .setToken(token);
              verificationToken.setAdmin(admin);
        verificationToken.setExpiryDate(LocalDateTime.now().plusMinutes(1));


        verificationTokenRepository.deleteAllByAdminId( admin.getId() );
        verificationTokenRepository.save( verificationToken );
        return token;
    }


    @Override
    public VerificationToken validateToken(String token, String email) {
        return null;
    }
}
