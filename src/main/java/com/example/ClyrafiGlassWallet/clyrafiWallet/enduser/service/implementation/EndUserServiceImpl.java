//package com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.service.implementation;
//
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.request.CompanyRegisterRequest;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.service.interfaces.CompanyService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.model.EndUser;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.repository.EndUserRepository;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.dtos.request.EndUserRegisterRequest;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.dtos.responses.EndUserRegisterResponse;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.service.interfaces.EndUserService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.utiles.EmailService;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.service.interfaces.WalletService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class EndUserServiceImpl implements EndUserService {
//    private final EndUserRepository endUserRepository;
//    private final WalletService walletService;
////    private final ApiKeyService apiKeyService;
//    private final EmailService emailService;
//    private final CompanyService companyService;
//    private final CompanyRepository companyRepository;
//
//    @Override
//    public EndUserRegisterResponse register( EndUserRegisterRequest endUserRegisterRequest) {
//        Company company = companyRepository.findById(endUserRegisterRequest.getCompanyId())
//                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
//
//        if (endUserRepository.findByCompanyIdAndEmail(company.getId(), endUserRegisterRequest.getEmail()).isPresent()) {
//            return EndUserRegisterResponse.builder()
//                    .success(false)
//                    .message("Email already exists in this company")
//                    .build();
//        }
//
//        if (endUserRepository.findByCompanyIdAndPhoneNumber(company.getId(), endUserRegisterRequest.getPhoneNumber()).isPresent()) {
//            return EndUserRegisterResponse.builder()
//                    .success(false)
//                    .message("Phone number already exists in this company")
//                    .build();
//        }
//
//        EndUser endUser = new EndUser();
//        endUser.setCompanyId(endUserRegisterRequest.getCompanyId());
//        endUser.setEmail(endUserRegisterRequest.getEmail());
//        endUser.setPhoneNumber(endUserRegisterRequest.getPhoneNumber());
//
//
//
//        endUser.setPassword(endUserRegisterRequest.getPassword());
//
//        EndUser savedUser = endUserRepository.save(endUser);
//
//
//        Wallet wallet = walletService.createWalletForUser(company, savedUser);
//
//
//        emailService.sendEmail(
//                savedUser.getEmail(),
//                "Welcome to Clyrafi Glass Wallet!",
//                "You have been registered successfully.\n\n" +
//                        "Your wallet address is: " + wallet.getWalletAddress()
//        );
//
//
//        return EndUserRegisterResponse.builder()
//                .success(true)
//                .message("User registered successfully")
//                .userId(savedUser.getId())
//                .walletAddress(wallet.getWalletAddress())
//                .build();
//    }
//
//
//
//    }
//
//
//
