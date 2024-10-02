package Sekedar.coba2.EmojiAnimasi;

public class PanahKanan {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\u2192"); // Panah ke kanan
                System.out.print("\u001b[5m"); // Efek kelap-kelip
                System.out.println("Malam memang tenang tapi tidak dengan fikiran");
                Thread.sleep(500);
                System.out.print("\r"); // Kembali ke awal baris
                System.out.println();
                System.out.println("why...");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
