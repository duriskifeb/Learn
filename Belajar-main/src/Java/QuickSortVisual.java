package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuickSortVisual extends JPanel implements ActionListener {

    private int[] array;
    private int comparisons = 0;
    private int swaps = 0;
    private Timer timer;
    private boolean sorted = false; // Flag untuk menghentikan ketika sudah terurut
    private int low = 0; // Indeks awal
    private int high; // Indeks akhir
    private int pivotIndex = -1; // Index untuk pivot
    private boolean partitioning = false; // Flag untuk menunjukkan sedang dalam proses partisi
    private int i, j; // Indeks untuk partisi

    public QuickSortVisual(int size) {
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Nilai acak dari 0 hingga 99
        }
        high = array.length - 1;
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
            quickSortStep(); // Lakukan langkah-langkah quick sort
        }
        repaint(); // Lakukan repaint untuk menggambar ulang tampilan
    }

    private void quickSortStep() {
        if (!partitioning) {
            if (low < high) {
                // Mulai partisi baru
                pivotIndex = partition(low, high);
                partitioning = true;
                i = low;
                j = high;
            } else {
                sorted = true;
                timer.stop(); // Hentikan timer setelah pengurutan selesai
            }
        } else {
            // Lanjutkan partisi berjalan
            if (i <= j) {
                comparisons++;
                if (array[i] < array[pivotIndex]) {
                    i++;
                } else if (array[j] > array[pivotIndex]) {
                    j--;
                } else {
                    // Tukar array[i] dan array[j]
                    swaps++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            } else {
                // Partisi selesai
                partitioning = false;
                // Rekursif pada subarray di kiri dan kanan
                if (low < pivotIndex - 1) {
                    high = pivotIndex - 1;
                } else if (pivotIndex + 1 < high) {
                    low = pivotIndex + 1;
                } else {
                    sorted = true;
                    timer.stop(); // Hentikan timer jika sudah selesai
                }
            }
        }
    }

    private int partition(int low, int high) {
        int pivot = array[low]; // Pilih elemen pertama sebagai pivot
        int i = low;
        int j = high;

        while (i < j) {
            while (i < array.length && array[i] <= pivot) {
                i++;
            }
            while (j >= 0 && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                // Tukar array[i] dan array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Tukar pivot dengan elemen j
        array[low] = array[j];
        array[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quick Sort Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuickSortVisual(20)); // Membuat panel QuickSort dengan 20 elemen
        frame.setSize(800, 600); // Ukuran jendela 800x600
        frame.setVisible(true); // Tampilkan jendela
    }
}
