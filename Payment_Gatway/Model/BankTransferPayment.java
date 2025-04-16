package Payment_Gatway.Model;

public class BankTransferPayment implements Payment {
    public void pay(double amount) {
        System.out.println("membayar" + amount + " mengunaan Transfer bank.");
    }
}
