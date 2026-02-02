package edu.uade.prog2;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;

public class SistemaTest {
    @Test
    public void nombredelaempresa() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("datos.json");
            Sistema sistema = gson.fromJson(reader, Sistema.class);
            assertEquals("mi sistema",sistema.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
