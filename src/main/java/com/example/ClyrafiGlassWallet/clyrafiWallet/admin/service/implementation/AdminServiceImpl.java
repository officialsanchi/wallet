package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.implementation;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.AdminRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.VerificationTokenRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.request.AdminRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.responses.AdminRegisterResponses;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.enums.VerificationStatus;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.AdminService;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.MailSenderService;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.VerificationTokenService;
import lombok.RequiredArgsConstructor;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
//    public AdminServiceImpl(AdminRepository adminRepository, VerificationTokenService verificationTokenService, MailSenderService mailSenderService) {
//        this.adminRepository = adminRepository;
//        this.verificationTokenService = verificationTokenService;
//        this.mailSenderService = mailSenderService;
//    }

    private final AdminRepository adminRepository;
    private final VerificationTokenService verificationTokenService;
    private final MailSenderService mailSenderService;

    @Override
    public AdminRegisterResponses registerAdmin(AdminRegisterRequest request) {

        validateRegisterRequest( request );

        Admin admin =  new  Admin ();

                admin.setSurname( request.getSurname() );
                admin.setFirstname( request.getFirstname() );
                admin.setOtherName( request.getOtherName() );
                admin.setEmail( request.getEmail() );
                admin.setPhoneNumber( request.getPhoneNumber() );
                admin.setVerificationStatus( VerificationStatus.PENDING );
               admin.setCreatedAt( LocalDateTime.now() );
               admin .setUpdatedAt( LocalDateTime.now() );


        adminRepository.save( admin );
        String token = verificationTokenService.generateToken( admin );
        sendVerificationEmail( token, admin.getEmail() );
        return AdminRegisterResponses.builder()
                .message( "Admin registered successfully" )
                .email( admin.getEmail()  )
                .adminId( admin.getId() )
                .status( admin.getVerificationStatus().name() )
                .build();
    }

    private void validateRegisterRequest(AdminRegisterRequest request) {
        if (adminRepository.existsByEmailIgnoreCase( request.getEmail())) {
            throw new IllegalArgumentException( "Email already exists" );
        }
        if (adminRepository.existsByPhoneNumber( request.getPhoneNumber() )) {
            throw new IllegalArgumentException( "Phone number already exists" );
        }
    }

    @Override
    public String resendVerificationEmail(String email) {
        Admin admin = adminRepository.findByEmailIgnoreCase( email )
                .orElseThrow( () -> new IllegalArgumentException( "Admin with this email does not exist" ) );

        if (admin.getVerificationStatus() == VerificationStatus.VERIFIED) {
            throw new IllegalStateException( "Admin is already verified" );
        }

        String token = verificationTokenService.generateToken( admin );
        sendVerificationEmail( token, admin.getEmail() );
//
//
//        tokenRepository.findByAdmin( admin ).ifPresent( tokenRepository::delete );
//
//
//        String token = UUID.randomUUID().toString();
//        VerificationToken verificationToken = VerificationToken.builder()
//                .token( token )
//                .admin( admin )
//                .expiryDate( LocalDateTime.now().plusHours( 24 ) )
//                .build();
//
//        tokenRepository.save( verificationToken );
//
//
//        String verificationUrl = "http://localhost:8080/api/admin/verify?token=" + token;
//        sendVerificationEmail( admin.getEmail(), verificationUrl );

        return "Verification email resent successfully. Please check your inbox.";
    }

    private void sendVerificationEmail(String token, String to) {
        String verificationUrl = "http://localhost:8080/api/admin/verify?token=" + token;

        String mailBody = String.format( "Click the link to verify your account: %s", verificationUrl );
        mailSenderService.sendEmail( to, "Verify your Admin account", mailBody );

    }
}




