package com.gj1e.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author FenDa
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(6666);
            Socket s = socket.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            System.out.println("message:"+in.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
