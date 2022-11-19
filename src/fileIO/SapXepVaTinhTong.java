package fileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SapXepVaTinhTong {
    public static ArrayList<Float> sort(String input) {
        StringTokenizer stringTokenizer = new StringTokenizer(input," ");
        float tong = 0;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            Float value = Float.parseFloat(token);
            arrayList.add(value);
            tong += value;
        }
        Collections.sort(arrayList);
        try {
            FileWriter output = new FileWriter("D:/java/Lap_trinh_mang/src/file/output.txt");
            output.write("Day so tang dan: " + arrayList.toString().substring(1, arrayList.toString().length()-1) + "\n");
            output.write("Tong cac so: " + tong);
            System.out.println("Day so tang dan: " + arrayList.toString().substring(1, arrayList.toString().length()-1));
            System.out.println("Tong cac so: " + tong);
            output.close();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void main(String[]ags) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("D:/java/Lap_trinh_mang/src/file/input.txt")));
        sort(input);
    }
}