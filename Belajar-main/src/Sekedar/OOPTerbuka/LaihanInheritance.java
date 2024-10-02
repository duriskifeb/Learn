package Sekedar.OOPTerbuka;

class Manusia {
    String nama;

    Manusia(String nama) {
        this.nama = nama;
    }

    void ingpo() {
        System.out.println("aku adalah " + nama);
    }
}

class Hewan extends Manusia {
    int jumlahOrang;

    Hewan(String jeneng, int suarane) {
        super(jeneng); // mengakses atribut dari class induk (
        this.jumlahOrang = jumlahOrang;
    }

    @Override 
    void ingpo() {
        System.out.println("ini adalah mbuh wes " + nama +" dengan " + jumlahOrang + "yaaa gitu...");
    }
}

public class LaihanInheritance {
    public static void main(String[] args) {
        Hewan kentir = new Hewan("yanto", 5);

        kentir.ingpo();
    }
}
