package lesson6.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запустился");

            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    String msg = sc.nextLine();
                    out.println(msg);
                }
            }).start();

            while (true) {
                String msg = in.nextLine();
                if (msg.equals("/end"))
                    break;
                System.out.println("Клиент: " + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
