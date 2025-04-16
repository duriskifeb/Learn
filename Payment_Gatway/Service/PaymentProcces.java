package Payment_Gatway.Service;

import Payment_Gatway.Model.Payment;
import Payment_Gatway.Model.Transaction;

public class PaymentProcces {
    //atribut
    //ini masih blom di add di file satunya
    private TransactionHistory transactionHistory;

    public PaymentProcces(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void processTrancaction(String id, double ammount, Payment paymentMethod){
        Transaction transaction = new Transaction(id, ammount, paymentMethod);
        transaction.processPayemnt();
        transactionHistory.addTransaction(transaction);
    } 
}   
