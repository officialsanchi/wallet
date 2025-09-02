package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class P2PTransferRequest  {
  private UUID senderCompanyId;
   private UUID receiverCompanyId;
   private long amount;
    private String reference;
}
