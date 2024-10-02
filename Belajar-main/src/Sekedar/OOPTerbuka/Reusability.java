package Sekedar.OOPTerbuka;


// Kelas utama (superclass)
class Kendaraan {
    String merek;

    Kendaraan(String merek) {
        this.merek = merek;
    }

    void info() {
        System.out.println("Ini adalah kendaraan merek " + merek);
    }
}

// Kelas turunan (subclass) yang mewarisi Kendaraan
class Mobil extends Kendaraan {
    int jumlahPintu;

    Mobil(String merek, int jumlahPintu) {
        // Memanggil konstruktor kelas induk (Kendaraan)
        super(merek);
        this.jumlahPintu = jumlahPintu;
    }

    // Override metode info dari kelas induk (Kendaraan)
    @Override
    void info() {
        System.out.println("Ini adalah mobil merek " + merek + " dengan " + jumlahPintu + " pintu.");
    }
}

// Kelas turunan (subclass) lain yang juga mewarisi Kendaraan
class SepedaMotor extends Kendaraan {
    boolean punyaKopling;

    SepedaMotor(String merek, boolean punyaKopling) {
        // Memanggil konstruktor kelas induk (Kendaraan)
        super(merek);
        this.punyaKopling = punyaKopling;
    }

    // Override metode info dari kelas induk (Kendaraan)
    @Override
    void info() {
        String memilikiKopling = punyaKopling ? "memiliki kopling" : "tidak memiliki kopling";
        System.out.println("Ini adalah sepeda motor merek " + merek + " dan " + memilikiKopling + ".");
    }
}

// Kelas utama untuk menjalankan program
public class Reusability {
    public static void main(String[] args) {
        // Membuat objek dari kelas turunan (Mobil)
        Mobil mobilToyota = new Mobil("Toyota", 4);
        
        // Memanggil metode info dari kelas turunan (Mobil)
        mobilToyota.info();

        // Membuat objek dari kelas turunan lain (SepedaMotor)
        SepedaMotor honda = new SepedaMotor("Honda", true);

        // Memanggil metode info dari kelas turunan lain (SepedaMotor)
        honda.info();
    }
}





