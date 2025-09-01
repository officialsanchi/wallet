package com.example.ClyrafiGlassWallet.clyrafiWallet.company.utiles;

import java.net.HttpURLConnection;
import java.net.URL;

public class CompanyLiveValidator {
    public static void validateEmailFormat(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email address format");
        }
    }

    public static void validatePhoneFormat(String phone) {
        if (phone == null || !phone.matches("^\\d{11}$")) {
            throw new IllegalArgumentException("Invalid phone number format (must be 11 digits)");
        }
    }

    public static void validateWebsiteIsLive(String websiteUrl) {
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
