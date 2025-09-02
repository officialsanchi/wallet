package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class FiatDepositRequest  {
   private UUID companyId;
   private String accountNumber;
   private String bankCode;
   private long amount;
   private String reference;
   private String email;

}
