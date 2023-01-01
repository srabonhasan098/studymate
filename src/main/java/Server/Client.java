package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable{
    String clientName;
    BufferedWriter writer;
    BufferedReader reader;

    final static ArrayList<Client> clients = new ArrayList<>();

    Client (Socket sc){
        try{
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);

            clientName = reader.readLine();
            clients.add(this);

            System.out.println("Client " + clientName + "connected.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        while (true){
            try{
                String data = reader.readLine();
                data = clientName + ":  " + data + "\n";
                synchronized (clients){
                    for (Client client: clients) {
                        System.out.println(client.clientName + " " +data);
                        //synchronized (client.writer) {
                        client.writer.write(data);
                        client.writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}