package Java;


public class BubbleSort {

    public static void bubbleSort(String[][] arr) {
        int n = arr.length;
        boolean swapped;

        // Melakukan perulangan sampai semua elemen terurut
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Bandingkan setiap elemen dengan elemen di sebelahnya
            for (int j = 0; j < n - i - 1; j++) {
                // Jika elemen saat ini lebih kecil dari elemen berikutnya, tukar posisinya
                if (Integer.parseInt(arr[j][2]) < Integer.parseInt(arr[j + 1][2])) { //disinilah letak logic perbandingan
                    // Tukar elemen arr[j] dan arr[j+1]
                    String[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // Tandai bahwa terjadi pertukaran
                    swapped = true;
                }
            }

            // Jika tidak ada pertukaran dalam satu iterasi, artinya sudah terurut
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Data mahasiswa
        String[][] mahasiswa = {
                { "Andi", "12345", "80" },
                { "Budi", "23456", "90" },
                { "Cici", "34567", "75" },
                { "Dedi", "45678", "85" }
        };

        // Panggil fungsi bubbleSort
        bubbleSort(mahasiswa);

        // Cetak hasil pengurutan
        System.out.println("Setelah diurutkan (berdasarkan nilai terbesar ke terkecil):");
        for (String[] mhs : mahasiswa) {
            System.out.println(mhs[0] + " - " + mhs[1] + " - " + mhs[2]);
        }
    }
}
