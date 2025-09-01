package com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.model.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    boolean existsByCompanyName(String companyName);
    boolean existsByCompanyEmail(String companyEmail);
    Optional<Company> findByIdAndCompanyEmail(UUID companyId, String email);

    // check phone within a company
//    Optional<Company> findByIdAndPhoneNumber(UUID companyId, String phoneNumber);
    Optional<Company> findByCompanyEmail(String companyEmail);
}
