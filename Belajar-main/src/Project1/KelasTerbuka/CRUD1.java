package Project1.KelasTerbuka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CRUD1 {

    public static void main(String[] args) throws IOException {

        Scanner terminalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isiLanjutkan = true;

        while (isiLanjutkan) {

            System.out.println("____________________________");
            System.out.println("|   Database perpustakaan  |");
            System.out.println("|__________________________|");
            System.out.println("|1. Lihat seluruh buku |");
            System.out.println("|2. cari data buku     |");
            System.out.println("|3. Tambah data buku   |");
            System.out.println("|4. Ubah data buku buku|");
            System.out.println("|5. hapus data buku    |");
            System.out.println("|0. menutup Aplikasi   |");
            System.out.println("|______________________|");
            
            System.out.print("\nPilihan anda : ");
            pilihanUser = terminalInput.next();
            System.out.println("\n=-=-=-=-=--=-=-=--=-=-=-=-=-=-=-=-=-=-=-=--=");
            
            
            
            switch (pilihanUser) {
                case "1":
                System.out.println("____________________");
                    System.out.println("Lihat seluruh buku");
                    System.out.println("____________________");
                    tampilkanData();
                    break;
                case "2":
                    System.out.println("____________________");
                    System.out.println("Cari seluruh buku");
                    System.out.println("____________________");
                    break;
                case "3":
                    System.out.println("____________________");
                    System.out.println("Tambah data buku");
                    System.out.println("____________________");
                    break;
                case "4":
                    System.out.println("____________________");
                    System.out.println("Ubah seluruh buku");
                    System.out.println("____________________");
                    break;
                case "5":
                    System.out.println("____________________");
                    System.out.println("Hapus seluruh buku");
                    System.out.println("____________________");
                    break;
                case "0":
                    System.out.println("____________________");
                    System.out.println("Menutup Aplikasi-nya");
                    System.out.println("____________________");
                    

                default:
                    System.err.println("\nInputan anda tidak di temukan\nsilahkan pilih [1-5] ");
                }
                
                isiLanjutkan = getYesorNo("Apakah anda ingin melanjutkan");
                
            System.out.println();

        }
    }
    
    
    private static void tampilkanData() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("src\\Project1\\Database.txt");
            bufferInput = new BufferedReader(fileInput);

        } catch (Exception e) {
            System.err.println("Database tidak di temukan");
            System.err.println("Silahkan Tambah data terlebih dahulu");
            return;
        }

        String data = bufferInput.readLine();

        StringTokenizer stringToken = new StringTokenizer(data, ",");

        System.out.println("_________________________________________________________________");
        System.out.println("\n| No |\tTahun   |\tPenulis    |\tPenerbit     |\tjudul Buku" );
        stringToken.nextToken();

        System.out.printf("|%2d ", 1);
        System.out.printf("|\t%4s ",stringToken.nextToken());
        System.out.printf("|\t%-10s ",stringToken.nextToken());
        System.out.printf("|\t%-10s ",stringToken.nextToken());
        System.out.printf("|\t%-10s ",stringToken.nextToken());

        
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

    private static void clearScreen() {

        try {
            if (System.getProperty("os.name").contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\123\123\123");
            }

        } catch (Exception e) {
            System.err.println("Tidak bisa clear screan...");
        }
    }
}

