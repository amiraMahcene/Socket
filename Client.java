package com.company;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

    class Client extends Thread{
    public void run() {

        try {
            Socket soc = new Socket("127.0.0.1", 2017);
            OutputStream os = soc.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(os);


            InputStream is = soc.getInputStream();
            ObjectInputStream in = new ObjectInputStream(is);


            //Message
            String m = "Client : Bonjour";
            out.writeObject(m);
            out.reset();
            System.out.println("Message envoye");

            //Message recu du serveur
            String message = (String) in.readObject();
            System.out.println(message);
        } catch (Exception ex) {

        }

    }



}