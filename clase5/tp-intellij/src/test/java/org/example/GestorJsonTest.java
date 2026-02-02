package org.example;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class GestorJsonTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() throws IOException {
        // Crear archivo datos.json de prueba
        try (FileWriter writer = new FileWriter("datos.json")) {
            writer.write("{\"nombre\": \"mi tp\"}");
        }
        // Redirigir salida estándar
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // Restaurar salida estándar
        System.setOut(originalOut);
        // Eliminar archivo de prueba
        new File("datos.json").delete();
    }

    @Test
    void testProcesarImprimeNombre() {
        GestorJson gestorJson = new GestorJson();
        gestorJson.procesar();
        assertTrue(outContent.toString().contains("mi tp"));
    }
}