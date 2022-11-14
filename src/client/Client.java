package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public final static String SERVER_IP = "10.10.12.204"; //"10.10.10.59";
    public final static int SERVER_PORT = 100;

    public static void main(String[]args) throws IOException, InterruptedException{
        Socket socket = null;
        String sentence_to_server = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            System.out.println("Connected: " + socket);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            while (true) {
                System.out.println("nhap");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                sentence_to_server ="Tuan : " + inFromUser.readLine();
                DataOutputStream outToServer = new DataOutputStream(os);
                outToServer.writeBytes(sentence_to_server + '\n');
            }
        } catch (IOException ie) {
            System.out.println("Can't connect to server");
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
