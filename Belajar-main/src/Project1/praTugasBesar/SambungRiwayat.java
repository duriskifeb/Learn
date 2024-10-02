package Project1.praTugasBesar;

import java.util.ArrayList;
import java.util.Scanner;

class Tiket {
    private String jenis;
    private int harga;
    private int stok;

    public Tiket(String jenis, int harga, int stok) {
        this.jenis = jenis;
        this.harga = harga;
        this.stok = stok;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
            System.out.println(jumlah + " tiket " + jenis + " berhasil dibeli.");
        } else {
            System.out.println("Stok tiket " + jenis + " tidak mencukupi.");
        }
    }
}

class Konser {
    private String nama;
    private ArrayList<Tiket> daftarTiket;

    public Konser(String nama) {
        this.nama = nama;
        this.daftarTiket = new ArrayList<>();
    }

    public void tambahTiket(String jenis, int harga, int stok) {
        Tiket tiket = new Tiket(jenis, harga, stok);
        daftarTiket.add(tiket);
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }
}

public class SambungRiwayat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi konser dan tiket
        Konser konser = new Konser("Konser A");
        konser.tambahTiket("Reguler", 50000, 50);
        konser.tambahTiket("VIP", 100000, 30);
        konser.tambahTiket("VVIP", 150000, 20);

        boolean lanjutkan = true;

        while (lanjutkan) {
            System.out.println("\nSelamat datang di " + konser.getNama());
            System.out.println("Daftar Tiket: ");

            ArrayList<Tiket> daftarTiket = konser.getDaftarTiket();
            for (int i = 0; i < daftarTiket.size(); i++) {
                Tiket tiket = daftarTiket.get(i);
                System.out.println((i + 1) + ". " + tiket.getJenis() + " - Rp " + tiket.getHarga() + " (Stok: " + tiket.getStok() + ")");
            }

            System.out.print("Pilih tiket (1-" + daftarTiket.size() + ") atau 0 untuk keluar: ");
            int pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= daftarTiket.size()) {
                Tiket tiketPilihan = daftarTiket.get(pilihan - 1);

                System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
                int jumlahBeli = input.nextInt();

                tiketPilihan.kurangiStok(jumlahBeli);
            } else if (pilihan == 0) {
                System.out.println("Terima kasih. Selamat tinggal!");
                lanjutkan = false;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
