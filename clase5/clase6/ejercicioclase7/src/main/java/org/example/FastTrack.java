package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class FastTrack {
    Map<String,Cliente> clientes = new HashMap<>();
    Map<String,Envio> envios = new HashMap<>();

    public void addCliente(String dni, String nombre, String email){
        Cliente cliente = new Cliente(dni,nombre,email);
        clientes.put(dni,cliente);
    }


    @Override
    public String toString() {
        return "FastTrack{" +
                "clientes=" + clientes +
                ", envios=" + envios +
                '}';
    }
}
