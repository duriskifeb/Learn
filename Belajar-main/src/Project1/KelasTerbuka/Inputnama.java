package Project1.KelasTerbuka;

import javax.swing.JOptionPane;

public class Inputnama {
    public static void main(String[] args) {
        // Meminta input nama
        String name = JOptionPane.showInputDialog("Masukkan Nama anda");

        // Menampilkan pesan dengan menggunakan input nama
        JOptionPane.showMessageDialog(null, "Hallo " + name);

        // Meminta input usia
        String ageInput = JOptionPane.showInputDialog("Masukkan usia anda");

        // Mengubah input usia menjadi tipe data integer
        int age = Integer.parseInt(ageInput);

        // Menampilkan pesan dengan menggunakan input usia
        JOptionPane.showMessageDialog(null, "Usia kamu adalah " + age + " tahun");

        // Meminta input nilai j
        String jInput = JOptionPane.showInputDialog("Masukkan nilai j anda ");

        // Mengubah input nilai j menjadi tipe data double
        double j = Double.parseDouble(jInput);

        // Menampilkan pesan dengan menggunakan input nilai j
        JOptionPane.showMessageDialog(null, "Nilai j kamu adalah " + j);
    }
}
