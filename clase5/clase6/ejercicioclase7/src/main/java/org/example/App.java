package org.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // FastTrack fastTrack = new FastTrack();

        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("datos.json");
            FastTrack fastTrack = gson.fromJson(reader, FastTrack.class);
            // fastTrack.addCliente("3453255","juan","algo@test");
            System.out.println(fastTrack);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }
}
