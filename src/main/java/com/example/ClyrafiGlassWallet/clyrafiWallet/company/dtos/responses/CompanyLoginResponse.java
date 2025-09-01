package com.example.ClyrafiGlassWallet.clyrafiWallet.company.dtos.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyLoginResponse {
    private String message;
    private String companyId;
    private String companyName;
    private String email;
}
