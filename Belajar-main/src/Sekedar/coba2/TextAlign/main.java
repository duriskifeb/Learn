package Sekedar.coba2.TextAlign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        String text = "Tulisan Tengah";

        // Mendapatkan lebar terminal
        int terminalWidth = getTerminalWidth();

        // Menghitung posisi awal untuk rata tengah
        int startPosition = Math.max(0, (terminalWidth - text.length()) / 2);

        // Membuat string dengan spasi untuk mencapai posisi awal
        String spaces = " ".repeat(startPosition);

        // Menampilkan teks yang dirata tengah
        System.out.println(spaces + text);
    }

    // Fungsi untuk mendapatkan lebar terminal
    private static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();
        int terminalWidth = 80; // Nilai default jika tidak dapat mendapatkan lebar terminal

        if (os.contains("win")) {
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                terminalWidth = Integer.parseInt(columns);
            }
        } else {
            try {
                Process process = new ProcessBuilder("tput", "cols").start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    terminalWidth = Integer.parseInt(line);
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace(); // Handle error accordingly
            }
        }

        return terminalWidth;
    }
}
