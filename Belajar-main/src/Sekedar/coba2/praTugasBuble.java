package Sekedar.coba2;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class praTugasBuble extends JFrame {
    private int[] array;

    public praTugasBuble(int size, int minValue, int maxValue) {
        // Membuat array dengan angka acak
        array = generateRandomArray(size, minValue, maxValue);

        // Mengatur properti JFrame
        setTitle("Vertical Array Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setContentPane(new DisplayPanel());
    }

    private int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
        }
        return array;
    }

    private class DisplayPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int max = Arrays.stream(array).max().orElse(0);

            int startX = 50;
            int startY = 350;

            for (int i = max; i > 0; i--) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] >= i) {
                        g.fillRect(startX + j * 30, startY - i * 10, 20, 10);
                    }
                }
            }

            // Mencetak angka di bagian bawah
            g.setColor(Color.BLACK);
            for (int i = 0; i < array.length; i++) {
                g.drawString(String.valueOf(array[i]), startX + i * 30, startY + 20);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            praTugasBuble frame = new praTugasBuble(10, 1, 100);
            frame.setVisible(true);
        });
    }
}
