package Payment_Gatway.Model;

public class EWalletPayment implements  Payment {
    public void pay(double amount) {
        System.out.print("Membayar " + amount +" menggunakan E-Wallet");
    }
    
}