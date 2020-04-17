package main.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1212);
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String messageInput = "";
            String messageOutput = "";

            while (!messageInput.equalsIgnoreCase("end")) {
                messageInput = inputStream.readUTF();
                System.out.println(messageInput);
                messageOutput = reader.readLine();
                outputStream.writeUTF(messageOutput);
                outputStream.flush();
            }
            socket.close();
        } catch (Exception e) {

        }
    }
}
