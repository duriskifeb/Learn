package Project1.praTugasBesar;


import java.util.Scanner;

class ademin {
    private int availableTickets;

    public ademin(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void increaseTickets(int amount) {
        if (amount > 0) {
            availableTickets += amount;
            System.out.println(amount + " tiket ditambahkan. Total tiket adalah: " + availableTickets);
        } else {
            System.out.println("Input tidak valid.");
        }
    }

    public void decreaseTickets(int amount) {
        if (amount > 0 && amount <= availableTickets) {
            availableTickets -= amount;
            System.out.println(amount + " tiket dihapus. Total tiket yang tersedia: " + availableTickets);
        } else {
            System.out.println("Jumlah tiket yang akan dihapus tidak valid atau tiket yang tersedia tidak mencukupi.");
        }
    }
}

public class Admin {
    public static void main(String[] args) {
        System.out.println("Admin Menu\n");

        ademin concert = new ademin(50); // Jumlah Tiket Awal

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Tambahkan Tiket");
            System.out.println("2. Kurangi Tiket");
            System.out.println("3. Cek Tiket Yang Tersedia");
            System.out.println("4. Keluar");
            System.out.print("Pilih Salah Satu Menu: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nomor Untuk Menambah Jumlah Tiket: ");
                    int addTickets = scanner.nextInt();
                    concert.increaseTickets(addTickets);
                    break;

                case 2:
                    System.out.print("Masukkan Nomor Untuk Mengurangi Jumlah Tiket: ");
                    int removeTickets = scanner.nextInt();
                    concert.decreaseTickets(removeTickets);
                    break;

                case 3:
                    System.out.println("Tiket Yang Tersedia: " + concert.getAvailableTickets());
                    break;

                case 4:
                    System.out.println("Mengeluarkan.....");
                    System.exit(0);

                default:
                    System.out.println("Pilihan Invalid, Silahkan Pilih Option Yang Ada.");
                    scanner.close();
            }
        }
    }
}
