package client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient {
    public final static int SERVER_PORT = 66;
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        try{
            System.out.println("Binding to port " + SERVER_PORT +  ", please wait");
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Baiting for a client...");
            while(true){
                try{
                    Socket socket = serverSocket.accept();
                    System.out.println("Cliend accepted: "+ socket);
//                    DataInputStream is = new DataInputStream(socket.getInputStream()) ;
//                    DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                    OutputStream os = socket.getOutputStream();
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
                    String line = "";

                    while(true){
                        line = br.readLine();
                        if (line == null || line.equalsIgnoreCase("quit")) break;
                        System.out.println("From " + socket.getInetAddress().getAddress() + ">" + line);
                        out.println("Response from K61 server: >>" + line);
                    }
                    socket.close();
                }catch (IOException e) {
                    System.err.println(" Connection Error: " + e);
                }
            }
        }catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
