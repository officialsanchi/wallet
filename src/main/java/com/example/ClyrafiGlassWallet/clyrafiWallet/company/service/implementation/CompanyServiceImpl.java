package com.example.ClyrafiGlassWallet.clyrafiWallet.company.service.implementation;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository.AdminRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.CompanyVerificationToken;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyVerificationTokenRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyLoginRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyRegisterRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses.CompanyLoginResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses.CompanyRegisterResponses;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.enums.CompanyStatus;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.service.interfaces.CompanyService;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.utiles.CompanyDatabaseValidator;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.utiles.CompanyLiveValidator;
import com.example.ClyrafiGlassWallet.clyrafiWallet.utiles.EmailService;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.implementation.WalletServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

//    public CompanyServiceImpl(CompanyRepository companyRepository,
//                              AdminRepository adminRepository,
//                              CompanyVerificationTokenRepository tokenRepository,
//                              EmailService emailService,
//                              PasswordEncoder passwordEncoder,
//                              WalletServiceImpl walletService)
//    {
//        this.companyRepository = companyRepository;
//        this.adminRepository = adminRepository;
//        this.tokenRepository = tokenRepository;
//        this.emailService = emailService;
////        this.passwordEncoder = passwordEncoder;
//        this.walletService = walletService;
//    }

    private final CompanyRepository companyRepository;
    private final AdminRepository adminRepository;
    private final CompanyVerificationTokenRepository tokenRepository;
    private final EmailService emailService;
//    private final PasswordEncoder passwordEncoder;
    private final WalletServiceImpl walletService;



    @Override
    @Transactional
    public CompanyRegisterResponses companyRegister(CompanyRegisterRequest companyRegisterRequest) {

//        Admin admin = adminRepository.findById(companyRegisterRequest.getAdmin().getId())
        Admin admin = adminRepository.findById(companyRegisterRequest.getAdminId())
                .orElseThrow(() -> new IllegalArgumentException("Admin not found"));
//        String encodedPassword = passwordEncoder.encode(companyRegisterRequest.getPassword());
        String encodedPassword = companyRegisterRequest.getPassword();

        Company company = Company.builder()
                .companyName(companyRegisterRequest.getCompanyName())
                .companyEmail(companyRegisterRequest.getCompanyEmail())
//                .password(encodedPassword)
                .natureOfBusiness(companyRegisterRequest.getNatureOfBusiness())
                .admin(admin)
                .status(CompanyStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Company company1 = companyRepository.save(company);

        walletService.createDefaultWalletsForCompany(company1);
        String token = UUID.randomUUID().toString();
        CompanyVerificationToken verificationToken = CompanyVerificationToken.builder()
                .token(token)
                .company(company1)
                .expiryDate(LocalDateTime.now().plusHours(24))
                .build();
        tokenRepository.save(verificationToken);


//        CompanyVerificationToken verificationToken = CompanyVerificationToken.builder()
//                .token(token)
//                .company(company)
//                .expiryDate(LocalDateTime.now().plusHours(24))
//                .build();
//        tokenRepository.save(verificationToken);


        String verificationUrl = "http://localhost:8080/api/company/verify?token=" + token;
        emailService.sendEmail(
                company.getCompanyEmail(),
                "Verify Your Company Account",
                "Click the link to verify your company account: " + verificationUrl
        );


        CompanyRegisterResponses response = new CompanyRegisterResponses();
        response.setMessage("Company registered. Verification email sent.");
        response.setEmail(company.getCompanyEmail());
        response.setStatus(company.getStatus().name());
        response.setWalletId(company1.getId().toString());
        response.setUserId(company.getId().toString());

        return response;
    }

    @Override
    public String verifyCompany(String token) {
        CompanyVerificationToken verificationToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Invalid token"));

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Token expired");
        }

        Company company = verificationToken.getCompany();
        company.setStatus( CompanyStatus.VERIFIED);
        companyRepository.save(company);

        return "Company successfully verified!";
    }

    @Override
    public String resendVerificationEmail(String companyEmail) {
        Company company = companyRepository.findByCompanyEmail(companyEmail)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        if (company.getStatus() == CompanyStatus.VERIFIED) {
            throw new IllegalStateException("Company is already verified");
        }

//
//        tokenRepository.findAll().stream()
//                .filter(t -> t.getCompany().getId().equals(company.getId()))
//                .forEach(tokenRepository::delete);


        String newToken = UUID.randomUUID().toString();
//        CompanyVerificationToken verificationToken = CompanyVerificationToken.builder()
//                .token(newToken)
//                .company(company)
//                .expiryDate(LocalDateTime.now().plusHours(24))
//                .build();

//        tokenRepository.save(verificationToken);


        String verificationUrl = "http://localhost:8080/api/company/verify?token=" + newToken;
        emailService.sendEmail(
                company.getCompanyEmail(),
                "Resend Verification - Company Account",
                "Click the link to verify your company account: " + verificationUrl
        );

        return "Verification email resent successfully";
    }

    @Override
    public CompanyLoginResponse login(CompanyLoginRequest request) {
        Company company = companyRepository.findByCompanyEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

//        if (!passwordEncoder.matches(request.getPassword(), company.getPassword())) {
//        if (request.getPassword().equals(company.getPassword())){
//            throw new IllegalArgumentException("Invalid email or password");
//        }

        if (company.getStatus() != CompanyStatus.VERIFIED) {
            throw new IllegalStateException("Company is not verified yet");
        }


        CompanyLoginResponse response = new CompanyLoginResponse();
        response.setMessage("Login successful");
        response.setCompanyId(company.getId().toString());
        response.setEmail(company.getCompanyEmail());
        response.setCompanyName(company.getCompanyName());
        return response;
    }
    }





