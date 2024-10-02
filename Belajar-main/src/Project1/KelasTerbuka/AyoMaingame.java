package Project1.KelasTerbuka;

import java.util.Scanner;

public class AyoMaingame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Apakah kamu inin bermain denagan ku pilih : [y/n] ");
        String respon = input.next();

        if (!respon.equals("y") && !respon.equals("n")) {
            System.out.println("Ayo main game bersamaku....");
        }
        else {
            System.out.println("kamu telah keluar dari game");
        }
    }
}
