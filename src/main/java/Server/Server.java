package Server;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            System.out.println("Server is waiting for client");
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true){
                Socket sc = serverSocket.accept();
                Client client = new Client(sc);
                Thread t = new Thread(client);
                t.start();
//                System.out.println(str);
            }
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }
}