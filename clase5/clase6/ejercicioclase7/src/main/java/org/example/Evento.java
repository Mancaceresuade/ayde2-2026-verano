package org.example;

public class Evento {
    String fecha;
    String descripcion;
    String estado;

    public Evento(String fecha, String descripcion, String estado) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    @Override
    public String toString() {
        return "Evento [fecha=" + fecha + ", descripcion=" + descripcion + ", estado=" + estado + "]";
    }
}
