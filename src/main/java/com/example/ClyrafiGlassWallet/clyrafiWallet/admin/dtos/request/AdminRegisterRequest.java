package com.example.ClyrafiGlassWallet.clyrafiWallet.admin.dtos.request;

import lombok.*;

import java.time.LocalDateTime;


//@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminRegisterRequest {

    private String surname;
    private String  firstname;
    private String otherName;
    private String phoneNumber;
    private String email;
    private String password;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getOtherName() {
//        return otherName;
//    }
//
//    public void setOtherName(String otherName) {
//        this.otherName = otherName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//
//
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
}
