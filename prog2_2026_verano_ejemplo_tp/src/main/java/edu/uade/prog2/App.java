package edu.uade.prog2;

import java.io.FileReader;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("datos.json");
            Sistema sistema = gson.fromJson(reader, Sistema.class);
            System.out.println(sistema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
