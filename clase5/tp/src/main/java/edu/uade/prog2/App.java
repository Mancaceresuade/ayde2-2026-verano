package edu.uade.prog2;

import java.io.FileNotFoundException;
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
            FileReader fileReader = new FileReader("datos.json");
            Sistema sistema = gson.fromJson(fileReader, Sistema.class);
            System.out.println(sistema);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }
}
