package Sekedar;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Msaukkan data diri anda : ");

        System.out.print("Nama anda : ");
        String nama = input.nextLine();

        System.out.print("Alamat anda : ");
        String alamat = input.nextLine();

        System.out.print("Hobi anda : ");
        String hobi = input.nextLine();

        System.out.println("\nHasil-nya : ");
        System.out.println("_______________________________________");
        System.out.println("Hallo...\t" + nama + " ");
        System.out.println("Alamat kamu disitu ya..?\t" + alamat + " ");
        System.out.println("Ohh.. Itu hobi kamu \t" + hobi + " ");
        System.out.println("_______________________________________");
        
    }
}
