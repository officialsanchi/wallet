package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces;

public interface MailSenderService {
    void sendEmail(String to, String subject, String body);
}
