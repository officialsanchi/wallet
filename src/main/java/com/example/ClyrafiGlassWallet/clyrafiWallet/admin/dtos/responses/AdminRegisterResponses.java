package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Builder
@Getter
public class AdminRegisterResponses {
    private String message;

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
    private String email;
    private String status;
    private UUID adminId;
}
