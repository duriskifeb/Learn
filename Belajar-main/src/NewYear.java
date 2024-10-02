import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class NewYear {
    public static void main(String[] args) {
        // Membuat objek CountDownLatch dengan hitungan mundur 5
        CountDownLatch countdownLatch = new CountDownLatch(5);

        // Membuat dan memulai thread untuk penghitungan mundur
        Thread countdownThread = new Thread(() -> {
            try {
                clearScreen();
                for (int i = 5; i > 0; i--) {
                    System.out.println("hitungan : " + i);
                    Thread.sleep(1000); // Jeda 1 detik
                    countdownLatch.countDown(); // Mengurangi hitungan mundur
                }

                // Menampilkan pesan setelah penghitungan mundur selesai
                System.out.println();
                System.out.println("Selamat Tahun barau 2024 :)");
                System.out.println("semoga yang ku semogakan tersemogakan");
                System.out.println("          ~ Amminn ~       ");
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Memulai thread penghitungan mundur
        countdownThread.start();

        try {
            // Menunggu sampai hitungan mundur mencapai 0
            countdownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("tidak bisa clear screen");
        }
    }

    
}
