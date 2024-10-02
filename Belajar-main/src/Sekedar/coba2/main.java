package Sekedar.coba2;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Membuat ArrayList untuk menyimpan data registrasi
        ArrayList<String> dataRegistrasi = new ArrayList<>();

        // Scanner untuk mendapatkan input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Melakukan registrasi pengguna
        String namaPengguna;
        do {
            System.out.print("Masukkan nama pengguna (atau ketik 'selesai' untuk keluar): ");
            namaPengguna = scanner.nextLine();

            if (!namaPengguna.equalsIgnoreCase("selesai")) {
                dataRegistrasi.add(namaPengguna);
                System.out.println("Registrasi berhasil untuk: " + namaPengguna + "\n");
            }
        } while (!namaPengguna.equalsIgnoreCase("selesai"));

        // Menampilkan data registrasi
        System.out.println("Data Registrasi:");
        for (String data : dataRegistrasi) {
            System.out.println(data);
        }

        // Menutup scanner
        scanner.close();
    }
}
