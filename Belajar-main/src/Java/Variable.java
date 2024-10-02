package Java;

public class Variable {

    // 1. Variabel static (kelas): Bersifat global untuk semua objek
    // Misalnya: Menyimpan jumlah total mahasiswa di kampus
    static int totalMahasiswa = 0;

    // 2. Variabel instance/inisiasi : Berbeda untuk setiap objek (mahasiswa)
    String nama; // Nama mahasiswa
    String nim; // NIM mahasiswa
    double ipk; // IPK mahasiswa

    // Constructor (parameter)
    // 3. Variabel parameter: Digunakan sebagai input untuk method atau constructor
    public Variable(String nama, String nim, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
        totalMahasiswa++; // Setiap kali objek Mahasiswa dibuat, total mahasiswa bertambah
    }

    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfoMahasiswa() {
        // 4. Variabel lokal: Dideklarasikan dalam method, hanya bisa diakses di method
        // itu
        String status = (ipk >= 3.0) ? "Lulus" : "Belum Lulus"; // Variabel lokal untuk menentukan status kelulusan

        // Menampilkan data mahasiswa
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("IPK: " + ipk);
        System.out.println("Status: " + status);
    }

    // Method static untuk menampilkan jumlah total mahasiswa
    public static void tampilkanTotalMahasiswa() {
        System.out.println("Total Mahasiswa di Kampus: " + totalMahasiswa);
    }

    public static void main(String[] args) {
        // Membuat beberapa objek mahasiswa (menggunakan variabel parameter)
        Variable mhs1 = new Variable("Andi", "12345", 3.5);
        Variable mhs2 = new Variable("Budi", "67890", 2.8);

        // Memanggil method untuk menampilkan informasi mahasiswa
        mhs1.tampilkanInfoMahasiswa();
        System.out.println(); // Baris kosong
        mhs2.tampilkanInfoMahasiswa();

        // Menampilkan jumlah total mahasiswa menggunakan variabel static
        System.out.println();
        Variable.tampilkanTotalMahasiswa();
    }
}   
