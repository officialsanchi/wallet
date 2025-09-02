package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.controller;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.VerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.AdminRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.VerificationTokenRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.request.AdminRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.responses.AdminRegisterResponses;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.AdminService;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.VerificationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor

public class AdminController {
    private final AdminService adminService;
    private final VerificationTokenService verificationTokenService;


    @PostMapping("/register")
    public ResponseEntity<AdminRegisterResponses> registerAdmin(@RequestBody AdminRegisterRequest request) {
        return ResponseEntity.status( HttpStatus.CREATED )
                .body( adminService.registerAdmin(request));
    }
    @PostMapping("/resend-verification-email")
    public ResponseEntity<String> resendVerificationEmail(@RequestParam String email) {
        return ResponseEntity.ok(adminService.resendVerificationEmail( email ));
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyAdmin(
            @RequestParam("token") String token,
            @RequestParam("email") String email) {

        VerificationToken verifiedToken = verificationTokenService.validateToken(token, email);
        return ResponseEntity.ok("Admin " + verifiedToken.getAdmin().getEmail() + " verified successfully!");
    }


//    private final VerificationTokenRepository tokenRepository;

//    public AdminController(VerificationTokenRepository tokenRepository, AdminRepository adminRepository, AdminService adminService) {
//        this.tokenRepository = tokenRepository;
//        this.adminRepository = adminRepository;
//        this.adminService = adminService;
//    }
//
//    private final AdminRepository adminRepository;
//    private final AdminService adminService;

//    @GetMapping("/verify")
//    public ResponseEntity<String> verifyAdmin(@RequestParam("token") String token) {
//        return tokenRepository.findByToken(token)
//                .map(verificationToken -> {
//                    if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
//
//                        String newToken = adminService.resendVerificationEmail(verificationToken.getAdmin().getEmail());
//                        return ResponseEntity.badRequest()
//                                .body("Token expired. A new verification link has been sent to your email.");
//                    }
//
//                    Admin admin = verificationToken.getAdmin();
//                    admin.setStatus( VerificationStatus.VERIFIED);
//                    admin.setUpdatedAt(LocalDateTime.now());
//                    adminRepository.save(admin);
//
//                    return ResponseEntity.ok("Admin verified successfully! You can now log in.");
//                })
//                .orElseGet(() -> ResponseEntity.badRequest().body("Invalid token"));
//    }
//
//    @PostMapping("/resend-verification")
//    public ResponseEntity<String> resendVerification(@RequestParam("email") String email) {
//        String response = adminService.resendVerificationEmail(email);
//        return ResponseEntity.ok(response);
//    }

}
