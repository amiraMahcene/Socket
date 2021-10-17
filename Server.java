package com.company;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    public void run() {
        try {
            //Creation socket
            ServerSocket sersoc = new ServerSocket(2017);

            //Ecoute
            System.out.println("Serveur en ecoute ..." );
            int i = 0;
            while (true) {
                //nouveau client
                Socket soc = sersoc.accept();
                i++;
                System.out.println("Nouveau Client " + i + " : " + soc.getInetAddress().getHostAddress());
                //flux d entre
                InputStream in = soc.getInputStream();
                ObjectInputStream entree = new ObjectInputStream(in);
                //flux de sortie
                OutputStream os = soc.getOutputStream();
                ObjectOutputStream sortie = new ObjectOutputStream(os);

                //reception du msg
                String m = (String) entree.readObject();
                System.out.println(m);



                //envoi de la reponse                            
                String mrep="Serveur: Merci pour l envoi";
                sortie.writeObject(mrep);
                sortie.reset();

            }
        } catch (Exception ex) {

        }

    }



}