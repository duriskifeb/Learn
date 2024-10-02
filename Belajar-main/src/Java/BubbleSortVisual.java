package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class BubbleSortVisual extends JPanel implements ActionListener {

    private int[] array;
    private int comparisons = 0;
    private int swaps = 0;
    private Timer timer;
    private boolean sorted = false; // Flag untuk menghentikan ketika sudah terurut
    private int i = 0; // Indeks perulangan luar
    private int j = 0; // Indeks perulangan dalam

    public BubbleSortVisual(int size) {
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
            bubbleSortStep(); // Sort dengan langkah per iterasi
        }
        repaint(); // Lakukan repaint untuk menggambar ulang tampilan
    }

    private void bubbleSortStep() {
        if (i < array.length - 1) { // Periksa apakah iterasi luar selesai
            if (j < array.length - i - 1) { // Iterasi dalam
                comparisons++;
                if (array[j] > array[j + 1]) {
                    swaps++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                j++; // Maju ke elemen berikutnya
            } else {
                j = 0; // Reset j untuk iterasi berikutnya
                i++; // Maju ke iterasi luar berikutnya
            }
        } else {
            sorted = true; // Array sudah terurut
            timer.stop(); // Hentikan timer setelah pengurutan selesai
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bubble Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BubbleSortVisual(20)); // Membuat panel BubbleSort dengan 20 elemen
        frame.setSize(800, 600); // Ukuran jendela 800x600
        frame.setVisible(true); // Tampilkan jendela
    }
}
