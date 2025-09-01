//package com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.repository;
//
//import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
//import com.example.ClyrafiGlassWallet.clyrafiWallet.enduser.data.model.EndUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//import java.util.UUID;
//
//public interface EndUserRepository extends JpaRepository<EndUser, UUID> {
//    Optional<EndUser> findByCompanyIdAndEmail(UUID companyId, String email);
//
//    Optional<EndUser> findByCompanyIdAndPhoneNumber(UUID companyId, String phoneNumber);
//
//    Optional<EndUser> findByCompanyIdAndUsername(UUID companyId, String username);
//
//}
