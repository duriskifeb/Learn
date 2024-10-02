package BroCode.Bagian1;

import java.util.Scanner;

public class Nested {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int rows;
        int coloms;
        String symbol = " ";

        System.out.print(" Enter of symbol # rows : ");
        rows = input.nextInt();
        System.out.print(" Enter of symbol # coloms : ");
        coloms = input.nextInt();
        System.out.print("Enter symbol for use : ");
        symbol = input.next();

        for (int i=1; i <= rows; i++) {
            System.out.println();
            for(int j = 1; j <= coloms; j++) {
                System.out.print(symbol);
            }
        }
        System.out.println();
    }
}
