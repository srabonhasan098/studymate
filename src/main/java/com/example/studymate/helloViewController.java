package com.example.studymate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class helloViewController {

@FXML
Button chatConnectButton;

@FXML
TextArea ChatBox;

@FXML
TextField msgInputField;

            boolean isConnected = false;

            BufferedReader reader;
            BufferedWriter writer;

@FXML
    void connectButtonPressed() {
            if (!isConnected) { //client is not connected with the server, connect with server

            String inputName = msgInputField.getText();
            msgInputField.clear();

            System.out.println(inputName);
            if(inputName == null || inputName.length() == 0){
            ChatBox.appendText("Please enter a valid name!\n");
            return;
            }
            try {
            Socket sc = new Socket("127.0.0.1", 5000);
            //Socket sc = new Socket("localhost", 6600);
            OutputStreamWriter o = new OutputStreamWriter(sc.getOutputStream());
            writer = new BufferedWriter(o);

            writer.write(inputName+"\n");
            writer.flush();

//                String name

            InputStreamReader isr = new InputStreamReader(sc.getInputStream());
            reader = new BufferedReader(isr);


//                  annonymous inner class
            Thread serverListener = new Thread(){
@Override
public void run(){
        while (true){
        try {
//                                String data = reader.readLine();
        String data = reader.readLine() + "\n";
        System.out.println(data);
        ChatBox.appendText(data);

        }
        catch (SocketException e){
        ChatBox.appendText("Connection Lost!\n");
        break;
        }
        catch (IOException e) {
        e.printStackTrace();
        }
        }
        }
        };
        serverListener.start();

        ChatBox.appendText("Connection Made & ACTIVE!\n");
        chatConnectButton.setText("SEND!");
        msgInputField.setPromptText("Write Your Query");
        isConnected = true;

        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        else {
        try{
        String msg = msgInputField.getText();
        msgInputField.clear();

        if (msg == null || msg.length() == 0){
        return;
        }

        writer.write(msg + "\n");
        writer.flush();
        }
        catch (IOException e){
        e.printStackTrace();
        }
        }
        }
}