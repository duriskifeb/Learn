package Payment_Gatway.Model;

public class Transaction {
    //inisisasi atribute
    private String id;
    private double amount;
    private Payment paymentMethod;

    public Transaction(String id, double amount, Payment paymentMethod) {
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void processPayemnt() {
        paymentMethod.pay(amount);
        System.out.println("Transaksi " + id + "Berhasil");
    }

    //toString karena mempermainkan data!
    @Override
    public String toString() {
        return "ID: " + id + ", Jumlah: " + amount + "Methode: " + paymentMethod.getClass().getSimpleName();
    }
}
