package Project1.KelasTerbuka;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileWriters {
    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("src\\Project1\\art.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.read();

        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}