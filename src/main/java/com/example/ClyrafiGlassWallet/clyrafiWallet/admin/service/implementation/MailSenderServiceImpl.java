package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.implementation;

import com.example.ClyrafiGlassWallet.clyrafiWallet.admin.service.interfaces.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class MailSenderServiceImpl implements MailSenderService {
    public MailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private final JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage mailMessage  = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject( subject );
        mailMessage.setText( body );
        javaMailSender.send( mailMessage );
    }
}
