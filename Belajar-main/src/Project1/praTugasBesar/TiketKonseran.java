package Project1.praTugasBesar;

import java.util.ArrayList;
import java.util.Scanner;

class Konser {
    private String namaKonser;
    private ArrayList<Tiket> daftarTiket;

    public Konser(String namaKonser) {
        this.namaKonser = namaKonser;
        this.daftarTiket = new ArrayList<>();
    }

    public void tambahTiket(String jenis, int harga, int jumlah) {
        Tiket tiket = new Tiket(jenis, this.namaKonser, harga, jumlah);
        this.daftarTiket.add(tiket);
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }
}

public class TiketKonseran {
    public static void main(String[] args) {
        // Inisialisasi data konser
        ArrayList<Konser> daftarKonser = new ArrayList<>();
        
        Konser Debatles = new Konser("Konser A");
        Debatles.tambahTiket("Reguler", 50000, 50);
        Debatles.tambahTiket("VIP", 100000, 30);
        Debatles.tambahTiket("VVIP", 150000, 20);
        daftarKonser.add(Debatles);
        
        Konser apalah_itu = new Konser("Konser A");
        apalah_itu.tambahTiket("Reguler", 50000, 50);
        apalah_itu.tambahTiket("VIP", 100000, 30);
        apalah_itu.tambahTiket("VVIP", 150000, 20);
        daftarKonser.add(apalah_itu);
        // Tambahkan konser lain jika diperlukan
        
        // Input pilihan konser
        Scanner input = new Scanner(System.in);
        System.out.println("Daftar Konser:");
        for (int i = 0; i < daftarKonser.size(); i++) {
            Konser konser = daftarKonser.get(i);
            System.out.println((i + 1) + ". " + konser.getNamaKonser());
        }

        System.out.println();
        System.out.print("Pilih konser (1-" + daftarKonser.size() + "): ");
        int pilihanKonser = input.nextInt();

        if (pilihanKonser >= 1 && pilihanKonser <= daftarKonser.size()) {
            Konser konserPilihan = daftarKonser.get(pilihanKonser - 1);
            ArrayList<Tiket> daftarTiketKonser = konserPilihan.getDaftarTiket();

            System.out.println("Daftar Tiket untuk " + konserPilihan.getNamaKonser() + ":");
            for (int i = 0; i < daftarTiketKonser.size(); i++) {
                Tiket tiket = daftarTiketKonser.get(i);
                System.out.println((i + 1) + ". " + tiket.getJenis() + " - Rp " + tiket.getHarga() + " (Stok: " + tiket.getJumlah() + ")");
            }

            System.out.println();
            System.out.print("Pilih jenis tiket (1-" + daftarTiketKonser.size() + "): ");
            int pilihanTiket = input.nextInt();

            // Input jumlah tiket yang akan dibeli
            System.out.println();
            System.out.print("Masukkan jumlah tiket yang akan dibeli: ");
            int jumlahBeli = input.nextInt();

            // Validasi pilihan tiket
            if (pilihanTiket >= 1 && pilihanTiket <= daftarTiketKonser.size()) {
                Tiket tiketPilihan = daftarTiketKonser.get(pilihanTiket - 1);

                // Validasi jumlah tiket yang akan dibeli
                if (jumlahBeli > 0 && jumlahBeli <= tiketPilihan.getJumlah()) {
                    // Hitung total harga
                    int totalHarga = tiketPilihan.getHarga() * jumlahBeli;
                    System.out.println("Total Harga: Rp " + totalHarga);

                    // Input pembayaran
                    System.out.print("Masukkan jumlah uang yang dibayarkan: Rp ");
                    int jumlahBayar = input.nextInt();

                    // Validasi pembayaran
                    if (jumlahBayar >= totalHarga) {
                        // Proses transaksi
                        int kembalian = jumlahBayar - totalHarga;
                        tiketPilihan.kurangiJumlah(jumlahBeli);

                        // pengkondisian setelah beli tiket apa mau beli lagi.?
                        System.out.println("Transaksi Berhasil!");
                        System.out.println("Terima kasih telah berbelanja.");
                        System.out.println("Kembalian: Rp " + kembalian);

                        // Tampilkan stok tiket setelah transaksi
                        System.out.println("Stok Tiket " + tiketPilihan.getNamaKonser() + " - " + tiketPilihan.getJenis() + " tersisa: " + tiketPilihan.getJumlah());
                    } else {
                        System.out.println("Pembayaran tidak mencukupi.");
                    }
                } else {
                    System.out.println("Jumlah tiket yang dibeli tidak valid.");
                }
            } else {
                System.out.println("Pilihan tiket tidak valid.");
            }
        } else {
            System.out.println("Pilihan konser tidak valid.");
        }
    }
}
