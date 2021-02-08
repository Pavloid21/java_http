package com.company;

import au.com.bytecode.opencsv.CSVReader;
import com.sun.net.httpserver.HttpServer;

import java.io.FileReader;
import java.net.InetSocketAddress;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader(args[0]), ';' , '"' , 1);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    //Verifying the read data here
                    System.out.println(Arrays.toString(nextLine));
                }
            }
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
            httpServer.createContext("/convert", new PostConvertHandler());
            httpServer.setExecutor(null); // creates a default executor
            httpServer.start();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    public double calulaotr(){
        // from (m | m\s | H*m | 27 m\s )
        // to (m | m\s | H*m | 27 m\s )
        return 0.0;
    }
}
