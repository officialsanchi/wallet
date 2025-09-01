package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.repository;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

//@Repository

public interface AdminRepository  extends JpaRepository<Admin, UUID> {
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<Admin> findByEmailIgnoreCase(String email);

}
