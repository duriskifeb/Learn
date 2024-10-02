package Sekedar.coba2.StyleText;

public class Arahnya {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\u2190"); // Panah ke kiri
                Thread.sleep(500);
                System.out.print("\u2191"); // Panah ke atas
                Thread.sleep(500);
                System.out.print("\u2192"); // Panah ke kanan
                Thread.sleep(500);
                System.out.print("\u2193"); // Panah ke bawah
                Thread.sleep(500);

                // Membersihkan baris sebelum mencetak kembali karakter
                System.out.print("\r");

                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

