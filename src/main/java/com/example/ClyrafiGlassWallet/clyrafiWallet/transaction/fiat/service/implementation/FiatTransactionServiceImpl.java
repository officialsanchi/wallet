package com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.implementation;


import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionStatus;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.enums.TransactionType;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.model.FiatTransaction;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.data.repository.FiatTransactionRepository;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatDepositRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.request.FiatWithdrawRequest;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatDepositResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatP2PResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.dtos.responses.FiatWithdrawResponse;
import com.example.ClyrafiGlassWallet.clyrafiWallet.transaction.fiat.service.interfaces.FiatTransactionService;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.model.Wallet;
import com.example.ClyrafiGlassWallet.clyrafiWallet.wallet.data.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FiatTransactionServiceImpl implements FiatTransactionService {
    private final FiatTransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final PaystackService paystackService;


    @Transactional
    public FiatDepositResponse deposit(FiatDepositRequest fiatDepositRequest) {
        Wallet wallet = walletRepository.findByCompanyId(fiatDepositRequest.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));


        FiatTransaction txn = FiatTransaction.builder()
                .walletId(wallet)
                .receiverAccountNumber( fiatDepositRequest.getAccountNumber() )
                .type(TransactionType.DEPOSIT)
                .amount(fiatDepositRequest.getAmount())
                .bankCode( fiatDepositRequest.getBankCode() )
                .status(TransactionStatus.PENDING)
                .reference(fiatDepositRequest.getReference())
                .email( fiatDepositRequest.getEmail() )
                .build();
       FiatTransaction savedFiatTransaction = transactionRepository.save(txn);

                paystackService.initializeDeposit( savedFiatTransaction.getAmount(), savedFiatTransaction.getEmail(), savedFiatTransaction.getReference());
        return null;
    }

    @Transactional
    @Override
    public FiatWithdrawResponse withdraw(FiatWithdrawRequest fiatWithdrawRequest) {
        Wallet wallet = walletRepository.findByCompanyId(fiatWithdrawRequest.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (wallet.getBalance() < fiatWithdrawRequest.getAmount()) {
            throw new RuntimeException("Insufficient balance");
        }
        FiatTransaction txn = FiatTransaction.builder()

                .walletId(wallet)
                .type(TransactionType.WITHDRAW)
                .amount(fiatWithdrawRequest.getAmount())
                .accountNumber( fiatWithdrawRequest.getAccountNumber()  )
                .bankCode(fiatWithdrawRequest.getBankCode())
                .status(TransactionStatus.PENDING)
                .isVerified(fiatWithdrawRequest.isVerified())
                .email( fiatWithdrawRequest.getEmail() )
                .reference(fiatWithdrawRequest.getReference())
                .build();
        FiatTransaction savedFiatTransaction = transactionRepository.save(txn);
        boolean isSuccessful = paystackService.verifyTransaction( savedFiatTransaction.getReference() );
        savedFiatTransaction.setStatus( TransactionStatus.SUCCESS );
        savedFiatTransaction = transactionRepository.save(txn);
        return FiatWithdrawResponse.builder()
                .message(isSuccessful ? "Withdrawal successful" : "Withdrawal failed")
                .build();








//        boolean sent = paystackService.initializeDeposit(amountMinor, reference);
//
//        if (sent) {
//            wallet.setBalance(wallet.getBalance() - amountMinor);
//            walletRepository.save(wallet);
//            txn.setStatus(TransactionStatus.SUCCESS);
//        } else {
//            txn.setStatus(TransactionStatus.FAILED);
//        }





    }




    @Transactional
    public FiatP2PResponse p2pTransfer(String senderCompanyId, String receiverCompanyId, long amountMinor, String reference) {
        Wallet senderWallet = walletRepository.findByCompanyId( UUID.fromString( senderCompanyId ) )
                .orElseThrow(() -> new RuntimeException("Sender wallet not found"));
        Wallet receiverWallet = walletRepository.findByCompanyId( UUID.fromString( receiverCompanyId ) )
                .orElseThrow(() -> new RuntimeException("Receiver wallet not found"));

        if (senderWallet.getBalance() < amountMinor) {
            throw new RuntimeException("Insufficient funds");
        }

        FiatTransaction txn = FiatTransaction.builder()
//                .senderAccountNumber( senderWallet.getWalletAddress()  )
//                .receiverAccountNumber( receiverWallet.getWalletAddress() )
//                .walletId(senderWallet.getId())
//                .type(TransactionType.TRANSFER)
//                .amountMinor(amountMinor)
//                .status(TransactionStatus.SUCCESS)
//                .reference(reference)
                .build();

        senderWallet.setBalance(senderWallet.getBalance() - amountMinor);
        receiverWallet.setBalance(receiverWallet.getBalance()+ amountMinor);

        walletRepository.save(senderWallet);
        walletRepository.save(receiverWallet);
         transactionRepository.save(txn);
        return FiatP2PResponse.builder()
                .message("Transfer successful")
                .build();
    }


}

