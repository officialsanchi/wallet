package com.example.ClyrafiGlassWallet.clyrafiWallet.company.utiles;

import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.model.Company;
import com.example.ClyrafiGlassWallet.clyrafiWallet.company.data.repository.CompanyRepository;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class CompanyDatabaseValidator {
    public void validateEmailFormat(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email address format");
        }
    }

    public void validatePhoneFormat(String phone) {
        if (phone == null || !phone.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("Invalid phone number format (must be 11 digits)");
        }
    }

    public void validateWebsiteIsLive(String websiteUrl) {
        try {
            if (!websiteUrl.startsWith("http")) {
                websiteUrl = "http://" + websiteUrl;
            }
            HttpURLConnection connection = (HttpURLConnection) new URL(websiteUrl).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            connection.connect();
            int status = connection.getResponseCode();
            if (status != 200) {
                throw new IllegalArgumentException("Website is not reachable (status: " + status + ")");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Website is not reachable");
        }
    }
}
