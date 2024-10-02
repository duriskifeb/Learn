package Java;

import java.util.List;
import java.util.ArrayList;

public class shorting {

    public static List<String[]> mergeShort(List<String[]> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int acc = arr.size() / 2;
        List<String[]> left = mergeShort(arr.subList(0, acc));
        List<String[]> right = mergeShort(arr.subList(acc, arr.size()));
        return merge(left, right);
    }

    public static List<String[]> merge(List<String[]> left, List<String[]> right) {
        List<String[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (Integer.parseInt(left.get(i)[2]) > Integer.parseInt(right.get(j)[2])) {
                result.add(left.get(i));
                i++; 
            }else{
                result.add(right.get(j));
                j++;
            }
        }
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, left.size()));
        return result;
    }

    public static void main(String[] args) {
        List<String[]> mahasiswa = new ArrayList<>();
        mahasiswa.add(new String[]{"saya", "malang", "22"});
        mahasiswa.add(new String[]{"kamu", "surabaya", "25"});
        mahasiswa.add(new String[]{"aku", "panjen", "29"});
        mahasiswa.add(new String[]{"loe", "darjoe", "26"});

        List<String[]> mahasiswaUrut = mergeShort(mahasiswa);

        for (String[] Mhs : mahasiswaUrut) {
            System.out.println(Mhs[0] + " - " + Mhs[1] + " - " + Mhs[2]);
        }
    }
}
