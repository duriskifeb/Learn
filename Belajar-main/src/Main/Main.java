package Main;


// import config.koneksi;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main   {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    private boolean isAdmin = false;

    public static void main(String[] args) throws SQLException, Exception {
        Main main = new Main();
        main.run();
    }

    private void run() throws SQLException, Exception {
        clear();
        login();
        while (true) {
            clear();
            if (isLoggedIn) {
                if (isAdmin) {
                    menuAdmin();
                } else {
                    menuKasir();
                }
            }
        }
    }

    private void login() throws SQLException, Exception {
        System.out.println("Pilih login sebagai");
        System.out.println("1. kasir");
        System.out.println("2. admin");
        System.out.print("pilih: ");
        String pilih = scanner.next();

        if (isNumeric(pilih)) {
            switch (pilih) {
                case "1":
                    loginKasir();
                    break;
                case "2":
                    loginAdmin();
                    break;
                default:
                    System.out.println("Masukkan input yang benar");
                    Thread.sleep(3000);
                    login();
            }
        } else {
            System.out.println("Masukkan input yang benar (angka)");
            Thread.sleep(3000);
            login();
        }
    }

    private void loginKasir() throws SQLException, Exception {
        // ...
    }

    private void loginAdmin() throws SQLException, Exception {
        // ...
    }

    private void menuKasir() throws SQLException, Exception {
        // ...
    }

    private void menuAdmin() throws SQLException, Exception {
        // ...
    }

    private void clear() {
        // ...
    }

    private boolean isNumeric(String strNum) {
        // ...
    }
}
