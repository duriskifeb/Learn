package Java;

public class Rekursif {

    // Fungsi rekursif untuk menghitung IPK hingga semester ke-n
    public static double hitungIPK(double[] ipSemester, int semester) {
        // Base case: jika hanya ada 1 semester, IPK sama dengan IP semester 1
        if (semester == 1) {
            return ipSemester[0]; // Semester pertama, tidak ada kumulasi
        }

        // Rekursi: hitung IPK hingga semester sebelumnya
        double ipkSebelumnya = hitungIPK(ipSemester, semester - 1);

        // Rumus untuk menghitung IPK kumulatif
        double ipkKumulatif = (ipkSebelumnya * (semester - 1) + ipSemester[semester - 1]) / semester;

        return ipkKumulatif;
    }

    public static void main(String[] args) {
        // Contoh nilai IP per semester
        double[] ipSemester = { 3.5, 3.8, 3.2, 3.9 }; // IP untuk semester 1 sampai 4

        // Jumlah semester yang dihitung
        int totalSemester = ipSemester.length;

        // Hitung IPK hingga semester terakhir
        double ipkFinal = hitungIPK(ipSemester, totalSemester);

        // Tampilkan hasil IPK kumulatif
        System.out.println("IPK kumulatif hingga semester " + totalSemester + " adalah: " + ipkFinal);
    }
}
