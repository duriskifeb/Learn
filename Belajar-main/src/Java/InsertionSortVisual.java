package Java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class InsertionSortVisual extends JPanel implements ActionListener {

    private int[] array;
    private int comparisons = 0;
    private int swaps = 0;
    private Timer timer;
    private boolean sorted = false; // Flag untuk menghentikan ketika sudah terurut
    private int i = 1; // Indeks perulangan luar (mulai dari elemen ke-1, karena elemen pertama
                       // dianggap sudah terurut)
    private int j = 0; // Indeks perulangan dalam (mulai dari elemen ke-i dan bergerak ke belakang)

    public InsertionSortVisual(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Nilai acak dari 0 hingga 99
        }
        timer = new Timer(100, this); // Timer dengan interval 100ms
        timer.start(); // Memulai timer
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(i * width, getHeight() - array[i], width, array[i]);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(array[i]), i * width + width / 2, getHeight() - array[i] - 10);
        }
        g.setColor(Color.RED);
        g.drawString("Comparisons: " + comparisons, 10, 20);
        g.drawString("Swaps: " + swaps, 10, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!sorted) { // Jika array belum terurut
            insertionSortStep(); // Sort dengan langkah per iterasi
        }
        repaint(); // Lakukan repaint untuk menggambar ulang tampilan
    }

    private void insertionSortStep() {
        if (i < array.length) { // Periksa apakah iterasi luar selesai
            if (j >= 0 && array[j] > array[j + 1]) { // Bandingkan dengan elemen di belakangnya
                comparisons++;
                swaps++;
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j--; // Maju ke elemen sebelumnya
            } else {
                i++; // Maju ke iterasi berikutnya untuk elemen baru
                j = i - 1; // Setel j ke elemen terakhir dari bagian yang terurut
            }
        } else {
            sorted = true; // Array sudah terurut
            timer.stop(); // Hentikan timer setelah pengurutan selesai
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Insertion Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new InsertionSortVisual(20)); // Membuat panel InsertionSort dengan 20 elemen
        frame.setSize(800, 600); // Ukuran jendela 800x600
        frame.setVisible(true); // Tampilkan jendela
    }
}
