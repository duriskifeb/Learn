package Sekedar.coba2.EmojiAnimasi;

public class SimbolPengalihan {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\u1F504"); // Simbol pengalihan
                System.out.print(" Semangat Rizky . .");
                Thread.sleep(500);
                System.out.print("\r"); // Kembali ke awal baris
                Thread.sleep(500);
                System.out.print("cobalah . . .");
                System.out.println("cobalah . . .");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
