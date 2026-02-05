package org.example;

import java.util.List;

public class Cliente {
    String nombreCliente;
    Integer numeroId;
    List<String> comprasOReservas;
    public Cliente(String nombreCliente,Integer numeroId) {
        if(numeroId == null) {
            throw new RuntimeException("El número de identificación no puede ser nulo");
        }
        this.nombreCliente = nombreCliente;

    }
}
