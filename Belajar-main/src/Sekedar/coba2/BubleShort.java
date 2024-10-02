package Sekedar.coba2;

public class BubleShort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 9, 10, 5, 7, 13};

        System.out.println("Array sebelum diurutkan:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\nArray setelah diurutkan:");
        printArray(arr);
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // Bandingkan elemen ke j dan j+1
                if (arr[j] > arr[j+1]) {
                    // Tukar jika diperlukan
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

