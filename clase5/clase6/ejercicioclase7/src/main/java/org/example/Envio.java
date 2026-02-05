package org.example;

import java.util.Stack;

public class Envio {
    String id;
    String fechaInicio;
    Double peso ;
    Double distancia;
    String idCliente;
    String tipo;
    Stack eventos = new Stack();

    public Envio(String id, String fechaInicio, Double peso, Double distancia, String idCliente, String tipo) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.peso = peso;
        this.distancia = distancia;
        this.idCliente = idCliente;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "id='" + id + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", peso=" + peso +
                ", distancia=" + distancia +
                ", idCliente='" + idCliente + '\'' +
                ", tipo='" + tipo + '\'' +
                ", eventos=" + eventos +
                '}';
    }
}
