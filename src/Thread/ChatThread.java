package Thread;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ChatThread extends Thread{
    Socket socket;

    public ChatThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            String message = is.readUTF();
            System.out.println("Client: " + message);
            os.writeUTF("Sap xep cac so: " + sort(message) + "\nTong: " + sum(message));
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Connection lost from: " + socket.getInetAddress().getHostAddress());
        }
    }
    public static ArrayList<Double> sort(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            Double value = Double.parseDouble(token);
            arrayList.add(value);
        }
        Collections.sort(arrayList);
        return arrayList;
    }
    public static double sum(String string) {
        double tong = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            Double value = Double.parseDouble(token);
            tong += value;
        }
        return tong;
    }
}