package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.stream.MalformedJsonException;

public class App
{
    public static void main( String[] args )
    {
        GestorJson gestorJson = new GestorJson();
        gestorJson.procesar();
    }
}
