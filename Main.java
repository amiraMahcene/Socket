package com.company;

public class Main {

    public static void main(String[] args) {
        Server srv = new Server();
        srv.start();
        Client clt = new Client();

        clt.start();

    }
}
