package Payment_Gatway.Service;

import java.util.ArrayList;
import java.util.List;

import Payment_Gatway.Model.Transaction;

public class TransactionHistory {
    private List<Transaction> transactionss = new ArrayList<>();

    public void addTransactionHistory(Transaction transaction) {
        transactionss.add(transaction);
    }

    public void showTransaction() {
        System.err.println("\n - Riwayat Transaksi -");
        if (transactionss.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        }else{
            for(Transaction transaction : transactionss)
            System.out.println(transaction);
        }
    }
}
