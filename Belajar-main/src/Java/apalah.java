package Java;


import java.util.Scanner;

public class apalah {
    static apalah tk = new apalah();
    static Scanner scanner = new Scanner(System.in);

    // Fungsi untuk validasi input numerik
    private static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Fungsi untuk membersihkan terminal
    private void clear() {
        // Pilihan 1: Gunakan ANSI escape code (lebih baik di terminal)
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    // Fungsi utama program
    public static void main(String[] args) {
        tk.runProgram();
    }

    // Logika untuk menjalankan program langsung ke menu
    private void runProgram() {
        clear();
        while (true) {
            clear();
            pilihMenu();
        }
    }

    // Fungsi pemilihan menu (Admin atau Kasir)
    private void pilihMenu() {
        System.out.println("=== PILIH MENU ===");
        System.out.println("1. Menu Admin");
        System.out.println("2. Menu Kasir");
        System.out.print("Pilih: ");
        String pilihan = scanner.next();

        if (isNumeric(pilihan)) {
            switch (pilihan) {
                case "1":
                    menuAdmin();
                    break;
                case "2":
                    menuKasir();
                    break;
                default:
                    System.out.println("Input tidak valid, coba lagi.");
            }
        } else {
            System.out.println("Masukkan harus berupa angka.");
        }
    }

    // Fungsi menu Kasir
    private void menuKasir() {
        System.out.println("=== MENU KASIR ===");
        System.out.println("1. Penjualan Obat");
        System.out.println("2. Pesanan");
        System.out.println("3. Kembali ke menu utama");
        System.out.print("Pilih: ");
        String menu = scanner.next();
        clear();
        penjualanobat ks1 = new penjualanobat();

        switch (menu) {
            case "1":
                System.out.println("== Penjualan Obat ==");
                ks1.viewAllPenjualanObat();
                break;
            case "2":
                System.out.println("== Pesanan ==");
                ks1.viewPesanan();
                break;
            case "3":
                pilihMenu();
                break;
            default:
                System.out.println("Input tidak valid, coba lagi.");
        }
    }

    // Fungsi menu Admin
    private void menuAdmin() {
        System.out.println("=== MENU ADMIN ===");
        System.out.println("1. Pembelian Obat");
        System.out.println("2. Detail Pembelian Obat");
        System.out.println("3. Supplier");
        System.out.println("4. Obat");
        System.out.println("5. Kasir");
        System.out.println("6. Penjualan Obat");
        System.out.println("7. Kembali ke menu utama");
        System.out.print("Pilih: ");
        String menu = scanner.next();
        clear();
        pembelianobat adm = new pembelianobat();
        supplier sup = new supplier();
        obat ob = new obat();
        kasir ks = new kasir();
        penjualanobat po = new penjualanobat();

        switch (menu) {
            case "1":
                System.out.println("== Pembelian Obat ==");
                adm.viewAllPembelianObat();
                break;
            case "2":
                System.out.println("== Detail Pembelian Obat ==");
                adm.viewAllDetailPembelianObat();
                break;
            case "3":
                System.out.println("== Supplier ==");
                sup.viewSupplier();
                break;
            case "4":
                System.out.println("== Obat ==");
                ob.viewAllObat();
                break;
            case "5":
                System.out.println("== Kasir ==");
                ks.viewKasir();
                break;
            case "6":
                System.out.println("== Penjualan Obat ==");
                po.viewAllPenjualanObat();
                break;
            case "7":
                pilihMenu();
                break;
            default:
                System.out.println("Input tidak valid, coba lagi.");
        }
    }

    // Dummy classes untuk menampilkan data (penjualanobat, pembelianobat, dll.)
    class penjualanobat {
        void viewAllPenjualanObat() {
            System.out.println("Menampilkan semua penjualan obat...");
        }

        void viewPesanan() {
            System.out.println("Menampilkan semua pesanan...");
        }
    }

    class pembelianobat {
        void viewAllPembelianObat() {
            System.out.println("Menampilkan semua pembelian obat...");
        }

        void viewAllDetailPembelianObat() {
            System.out.println("Menampilkan detail pembelian obat...");
        }
    }

    class supplier {
        void viewSupplier() {
            System.out.println("Menampilkan data supplier...");
        }
    }

    class obat {
        void viewAllObat() {
            System.out.println("Menampilkan semua data obat...");
        }
    }

    class kasir {
        void viewKasir() {
            System.out.println("Menampilkan data kasir...");
        }
    }
}
