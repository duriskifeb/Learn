package Payment_Gatway;

import java.util.Scanner;

import Payment_Gatway.Model.BankTransferPayment;
import Payment_Gatway.Model.CreditCardPayment;
import Payment_Gatway.Model.EWalletPayment;
import Payment_Gatway.Model.Payment;
import Payment_Gatway.Model.Transaction;
import Payment_Gatway.Service.PaymentProcces;
import Payment_Gatway.Service.TransactionHistory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionHistory history = new TransactionHistory();
        PaymentProcces processor = new PaymentProcces(history);
        Payment creditCard = new CreditCardPayment();
        Payment eWallet = new EWalletPayment();
        Payment bankTransfer = new BankTransferPayment();
        //simulasi transaksi
        processor.processTrancaction("TXN001", 100, creditCard);
        processor.processTrancaction("TXN002", 200, eWallet);
        processor.processTrancaction("TXN003", 300, bankTransfer);
        // menampilkan riwayat transaksi setelah pembayaran di lakukan
        history.showTransaction();
        // menyampaikan fitur interaktif untuk melihat riwayat transaksi
        System.out.println("\nIngin melihat riwayat transaksi lagi? (y/n)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            history.showTransaction();
        }
        System.out.println("Terimakasih telah menggunakan sistem pembayaran!");
        scanner.close();
    }
}
//sek eror mas
