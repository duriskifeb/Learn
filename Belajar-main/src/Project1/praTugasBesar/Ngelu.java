package Project1.praTugasBesar;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

import Project1.RevisiDone.Pembuka;

class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}

class Tiket {
    private String jenis;
    private String namaKonser;
    private int harga;
    private int jumlah;

    public Tiket(String jenis, String namaKonser, int harga, int jumlah) {
        this.jenis = jenis;
        this.namaKonser = namaKonser;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void kurangiJumlah(int jumlah) {
        if (jumlah <= this.jumlah) {
            this.jumlah -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi.");
        }
    }
}


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


class Concert {
    private int availableTickets;

    public Concert(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void increaseTickets(int amount) {
        if (amount > 0) {
            availableTickets += amount;
            System.out.println(amount + " tiket ditambahkan. Total tiket adalah: " + availableTickets);
        } else {
            System.out.println("Input tidak valid.");
        }
    }

    public void decreaseTickets(int amount) {
        if (amount > 0 && amount <= availableTickets) {
            availableTickets -= amount;
            System.out.println(amount + " tiket dihapus. Total tiket yang tersedia: " + availableTickets);
        } else {
            System.out.println("Jumlah tiket yang akan dihapus tidak valid atau tiket yang tersedia tidak mencukupi.");
        }
    }
}

public class Ngelu {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        // Inisialisasi ArrayList untuk menyimpan data user
        ArrayList<User> userDatabase = new ArrayList<>();

        clearScreen();
        System.out.println("\t---------------------------------------------------------");
        System.out.println("\t >---> SELAMAT DATANG DI APLIKASI KONSER kELOMPOK 4 <---<");
        System.out.println("\t---------------------------------------------------------");
        Pembuka.tampilkanIsiFile("D:\\My Repo\\Belajar\\src\\Project1\\TugasBesar\\LebihBesar\\Muqodimah.txt");

        userDatabase.add(new User("user1", "USR1", "customer"));
        userDatabase.add(new User("admin1", "cok", "admin"));

        System.out.print("Masukkan username: ");
        String inputUsername = input.nextLine();

        System.out.print("Masukkan password: ");
        String inputPassword = input.nextLine();

        // Proses login
        User loggedInUser = null;
        for (User user : userDatabase) {
            if (inputUsername.equals(user.getUsername()) && inputPassword.equals(user.getPassword())) {
                if (user.getRole().equals("admin")) {
                    Ngelu2.showMenuAdmin();
                    break;
                } else {
                    loggedInUser = user;
                    break;
                }
            }
        }

        if (loggedInUser != null) {
            System.out.println("\n[Login berhasil..] ");
            System.out.println("\n--o0 Selamat datag di aplikasi kami 0o--");
            if (loggedInUser.getRole().equals("customer")) {
                displayCustomerMenu();
                // Lakukan aksi untuk customer
            } else if (loggedInUser.getRole().equals("admin")) {
                displayAdminMenu();
                // Lakukan aksi untuk admin
            }
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    //ini buat list konser.?
    
    public static void konseran() {
        // Inisialisasi data konser
        ArrayList<Konser> daftarKonser = new ArrayList<>();

        // Opsi "0" sebagai keluar dari loop
        
        Konser Tulus_Album_Manusia = new Konser("1. Tulus - Album Manusia");
        Tulus_Album_Manusia.tambahTiket("1.Reguler", 50000, 50);
        Tulus_Album_Manusia.tambahTiket("2.VIP", 100000, 30);
        Tulus_Album_Manusia.tambahTiket("3.VVIP", 150000, 20);
        daftarKonser.add(Tulus_Album_Manusia);

        Konser Coldplay_Tour_Indonesia = new Konser("2. Coldplay - Tour in Indonesia");
        Coldplay_Tour_Indonesia.tambahTiket("1.Reguler", 50000, 50);
        Coldplay_Tour_Indonesia.tambahTiket("2.VIP", 100000, 30);
        Coldplay_Tour_Indonesia.tambahTiket("3.VVIP", 150000, 20);
        daftarKonser.add(Coldplay_Tour_Indonesia);
        
        Konser JKT_48_12_Tahun_Aniversary = new Konser("3. JKT 48 - 12 Tahun Aniveersary");
        JKT_48_12_Tahun_Aniversary.tambahTiket("1.Reguler", 50000, 50);
        JKT_48_12_Tahun_Aniversary.tambahTiket("2.VIP", 100000, 30);
        JKT_48_12_Tahun_Aniversary.tambahTiket("3.VVIP", 150000, 20);
        daftarKonser.add(JKT_48_12_Tahun_Aniversary);
        //opsi untuk keluar
        daftarKonser.add(new Konser("0. Keluar"));
        // Tambahkan konser lain jika diperlukan
        
        // Input pilihan konser
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Beli Tiket Konser:");
            for (int i = 0; i < daftarKonser.size(); i++) {
                System.out.println(daftarKonser.get(i).getNamaKonser());
            }

            System.out.println();
            System.out.print("Pilih konser (0-" + (daftarKonser.size() - 1) + "): ");
            int pilihanKonser = input.nextInt();

            if (pilihanKonser == 0) {
                System.out.println("Terima kasih. Selamat tinggal!");
                break; // Keluar dari loop jika pilihan 0
            }

            if (pilihanKonser >= 1 && pilihanKonser <= daftarKonser.size()) {
                Konser konserPilihan = daftarKonser.get(pilihanKonser - 1);
                ArrayList<Tiket> daftarTiketKonser = konserPilihan.getDaftarTiket();

                System.out.println("\nDaftar Tiket untuk o=> " + konserPilihan.getNamaKonser() + " :\n");
                for (int i = 0; i < daftarTiketKonser.size(); i++) {
                    Tiket tiket = daftarTiketKonser.get(i);
                    System.out.println( tiket.getJenis() + " - Rp " + tiket.getHarga() + " (Stok: "
                            + tiket.getJumlah() + ")");
                }

                System.out.println("0. Tidak beli tiket");
                System.out.println();
                System.out.print("Pilih jenis tiket (0-" + daftarTiketKonser.size() + ") : ");
                int pilihanTiketU = input.nextInt();
                System.out.println();

                if (pilihanTiketU == 0) {
                    System.out.println("Anda memilih untuk tidak membeli tiket. Terima kasih!");
                    break; // Keluar dari loop jika pilihan 0
                }

                System.out.println();
                System.out.print("Pilih jenis tiket (1-" + daftarTiketKonser.size() + ") : "  );
                int pilihanTiket = input.nextInt();
                System.out.println();

                if (pilihanTiket >= 1 && pilihanTiket <= daftarTiketKonser.size()) {
                    Tiket tiketPilihan = daftarTiketKonser.get(pilihanTiket - 1);

                    System.out.println("Stok Tiket    :" +"      o=> " + tiketPilihan.getNamaKonser() + " <=o\n"
                            + tiketPilihan.getJenis() + " tersisa : " + tiketPilihan.getJumlah());

                    System.out.println();
                    System.out.print("Masukkan jumlah tiket yang akan dibeli : ");
                    int jumlahBeli = input.nextInt();
                    System.out.println();

                    if (jumlahBeli > 0 && jumlahBeli <= tiketPilihan.getJumlah()) {
                        int totalHarga = tiketPilihan.getHarga() * jumlahBeli;
                        System.out.println("Total Harga untuk " + jumlahBeli + " tiket : \n"
                                + tiketPilihan.getJenis() + ": Rp " + totalHarga);

                        System.out.println();
                        System.out.print("Masukkan jumlah uang yang dibayarkan : Rp ");
                        int jumlahBayar = input.nextInt();

                        if (jumlahBayar >= totalHarga) {
                            int kembalian = jumlahBayar - totalHarga;
                            tiketPilihan.kurangiJumlah(jumlahBeli);

                            System.out.println("Kembalian: Rp " + kembalian);
                            System.out.println("\n[ Transaksi Berhasil ]\n");
                           
                            // Tampilkan stok tiket setelah transaksi
                            System.out.println("Stok Tiket " + tiketPilihan.getNamaKonser() + " - "
                                    + tiketPilihan.getJenis() + " tersisa: " + tiketPilihan.getJumlah());

                            System.out.print("\nApakah Anda ingin membeli tiket konser lain? (ya/tidak) : ");
                            String lanjutBeli = input.next().toLowerCase();
                            System.out.println();

                            if (lanjutBeli.equals("ya")) {
                                continue;
                            } else {
                                System.out.println("\nTerima kasih, Anda telah berbelanja.\n");
                                displayCustomerMenu(); // Tambahkan ini untuk kembali ke menu customer
                                break; // Tambahkan ini agar keluar dari loop setelah kembali ke menu customer
                            }
                            
                        } else {
                            System.out.println("Pembayaran tidak mencukupi.");
                        }
                        System.out.println("\nTerimakasih anda telah beli tiket\n");
                    } else {
                        System.out.println("Jumlah tiket yang dibeli tidak valid.");
                    }
                } else {
                    System.out.println("Pilihan tiket tidak valid.");
                }
            } else {
                System.out.println("Pilihan konser tidak valid.");
            }
        } while (true);
        displayCustomerMenu();
    }
    

    public static void displayCustomerMenu() {
        Scanner input = new Scanner(System.in);
        // int pilihan = 0;
        boolean pilihan = true;
        boolean yakin = true;
        String pilihanUser;

        while (pilihan) {
            System.out.println("\nMenu customer : ");
            System.out.println("1. Lihat jadwal event Konser");
            System.out.println("2. beli Tiket Konser");
            System.out.println("3. Lihat riwayat pembelian Tiket Konser");
            System.out.println("0. Menutup Aplikasi");

            System.out.print("\nPilihan anda :");
            pilihanUser = input.nextLine();

            switch (pilihanUser) {
                case "1":
                    System.out.println("1. Lihat jadwal event Konser\n");
                    try {
                        tampilkanData();

                    } catch (Exception e) {
                        System.err.println("Maaf terjadi kesalahan..!!" + e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("\n2. Beli Tiket konser\n");
                    konseran();
                    break;
                case "3":
                    System.out.println("3. Lihat riwayat pembelian Tiket Konser");
                    // riwayat pembelian tiket konser
                    break;
                case "0":
                    System.out.println("0. Menutup Aplikasi");
                    lihatRiwayatPembelian();
                    CloseAPK();
                    System.exit(0);
                    break;

                default:
                    System.err.println("Maaf... Pilihan anda tidak ada pilih [1 - 2] : ");
                    break;
            }

            yakin = getYesorNo("Apakah anda ingin melanjutkan.?");
        }

    }

    private static boolean getYesorNo(String messeage) {

        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n" + messeage + " [y/n] : ");
        String pilihanUser = terminalInput.next();
        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {

            System.err.println("Maaf pilihan ana bukan y dan n");
            System.out.print("\n" + messeage + " [y/n] : ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    public static boolean pilihYesatauNO2(String messeage) {

        Scanner stasiunInput = new Scanner(System.in);

        System.out.print("\n" + messeage + " [y/n] : ");
        String pilihanUser = stasiunInput.next();
        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Maaf pilihan ana bukan y dan n");
            System.out.print("\n" + messeage + " [y/n] : ");
            pilihanUser = stasiunInput.next();
        }

        if (pilihanUser.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean pilihYesatauNO1(String messeage) {

        Scanner stasiunInput = new Scanner(System.in);

        System.out.print("\n" + messeage + " [y/n] : ");
        String pilihanUser = stasiunInput.next();
        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Maaf pilihan ana bukan y dan n");
            System.out.print("\n" + messeage + " [y/n] : ");
            pilihanUser = stasiunInput.next();
        }

        if (pilihanUser.equalsIgnoreCase("y")) {
            return true;
        } else {
            displayCustomerMenu();
            return false;
        }
    }

    public static void CloseAPK() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e);
        }

    }

    private static boolean pilihYesatauNO(String pertanyaan) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(pertanyaan + " (yes/no): ");
            String jawaban = input.next().toLowerCase();

            if (jawaban.equals("yes")) {
                return true;
            } else if (jawaban.equals("no")) {
                return false;
            } else {
                System.out.println("Pilihan tidak valid. Silakan masukkan 'yes' atau 'no'.");
            }
        }
    }

    private static void lihatRiwayatPembelian() {
        // Logika untuk melihat riwayat pembelian
        System.out.println("Menampilkan riwayat pembelian...");
    }

    public static void tampilkanData() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("src\\Project1\\TugasBesar\\LebihBesar\\Info_Konser.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Database Tidak ditemukan");
            System.err.println("Silahkan tambah data terlebih dahoeloe");
            return;
        }

        System.out.println("\n| No |\t     Nama Konser                 |\tTempat        |\t     Waktu       ");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");

        String data = bufferInput.readLine();
        int nomorData = 0;
        while (data != null) {
            nomorData++;

            StringTokenizer stringToken = new StringTokenizer(data, ",");

            stringToken.nextToken();
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%3s  ", stringToken.nextToken());
            System.out.printf("|\t%3s   ", stringToken.nextToken());
            System.out.printf("|\t%3s    ", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
    }

    public static void tampilkanIsiFile(String filePath) throws IOException {
        // Gunakan Paths.get() untuk membuat objek Path dari path file
        Path path = Paths.get(filePath);

        // Gunakan Files.readAllLines() untuk membaca semua baris dari file ke dalam
        // List
        List<String> baris = Files.readAllLines(path);

        // Tampilkan setiap baris di konsol
        for (String line : baris) {
            System.out.println(line);
        }
    }

    public static void displayAdminMenu() {
        // ga ono.?
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

    class Concert {
        private int availableTickets;

        public Concert(int initialTickets) {
            this.availableTickets = initialTickets;
        }

        public int getAvailableTickets() {
            return availableTickets;
        }

        public void increaseTickets(int amount) {
            if (amount > 0) {
                availableTickets += amount;
                System.out.println(amount + " tiket ditambahkan. Total tiket adalah: " + availableTickets);
            } else {
                System.out.println("Input tidak valid.");
            }
        }

        public void decreaseTickets(int amount) {
            if (amount > 0 && amount <= availableTickets) {
                availableTickets -= amount;
                System.out.println(amount + " tiket dihapus. Total tiket yang tersedia: " + availableTickets);
            } else {
                System.out.println(
                        "Jumlah tiket yang akan dihapus tidak valid atau tiket yang tersedia tidak mencukupi.");
            }
        }
    }
}
