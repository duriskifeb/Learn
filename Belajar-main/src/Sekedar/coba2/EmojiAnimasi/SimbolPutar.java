package Sekedar.coba2.EmojiAnimasi;


public class SimbolPutar {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\u1F50Malam Memang Tenang,"); // Simbol putar
                System.out.print("Tapi tidak dengan fikiran");
                Thread.sleep(500);
                System.out.print("\r"); // Kembali ke awal baris
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
