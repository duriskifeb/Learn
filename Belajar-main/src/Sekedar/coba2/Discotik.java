package Sekedar.coba2;

public class Discotik {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\u001b[2J"); // Membersihkan layar terminal
                System.out.print("\u001b[H");  // Mengembalikan kursor ke posisi awal

                // Menampilkan teks dengan warna dan efek kelap-kelip
                System.out.print("\u001b[5m");  // Efek kelap-kelip
                System.out.print("\u001b[35m"); // Warna ungu
                System.out.println("Selamat Malam!");
                System.out.println("Malam ku tenang, angin berhembus kencang");
                System.out.println("Tapi tidak dengan fikiran yang selalu ingin berangan kedepan.?\n");
                System.out.println("Tapi tidak disertai dengan Usaha yang mapan.?");

                System.out.print("\u001b[0m");  // Mengembalikan efek dan warna ke normal

                Thread.sleep(500); // Menunda selama setengah detik
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

