package Payment_Gatway.Model;

public class CreditCardPayment implements Payment {
     public void pay(double amount) {
        System.out.print("Membayar " + amount + " menggunakan kartu Kredit.");
     }   
}