package main.java;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",1212);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String messageInput = "";
            String messageOutput = "";

            while (!messageInput.equalsIgnoreCase("end")){
                messageOutput = reader.readLine();
                outputStream.writeUTF(messageOutput);
                messageInput = inputStream.readUTF();
                System.out.println(messageInput);
            }
        } catch (Exception e) {

        }

    }
}
