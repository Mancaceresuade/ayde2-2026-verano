package edu.uade.prog2;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;

public class SistemaTest {
    
    @Test
    public void nombreDeEmpresaDeberiaDevolverNombre() {

        Gson gson = new Gson();
        try {
            FileReader fileReader = new FileReader("datos.json");
            Sistema sistema = gson.fromJson(fileReader, Sistema.class);
            assertEquals("mi tp",sistema.toString());
            
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

    }
}
