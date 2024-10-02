package Sekedar.OOPTerbuka;

// Kelas induk atau superclass
class Kendaraan {
    String merek;

    Kendaraan(String merek) {
        this.merek = merek;
    }

    void info() {
        System.out.println("Ini adalah kendaraan merek " + merek);
    }
}

// Kelas anak atau subclass yang mewarisi dari Kendaraan
class Mobil extends Kendaraan {
    int jumlahPintu;

    Mobil(String merek, int jumlahPintu) {
        // Memanggil konstruktor kelas induk
        super(merek);
        this.jumlahPintu = jumlahPintu;
    }

    // Override metode info dari kelas induk
    @Override
    void info() {
        System.out.println("Ini adalah mobil merek " + merek + " dengan " + jumlahPintu + " pintu.");
    }
}

// Kelas utama untuk menjalankan program
public class inheritance {
    public static void main(String[] args) {
        // Membuat objek dari kelas anak (Mobil)
        Mobil mobilToyota = new Mobil("Toyota", 4);

        // Memanggil metode info dari kelas anak
        mobilToyota.info();
    }
}
