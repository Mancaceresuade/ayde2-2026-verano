package edu.uade.prog2;

public class Sistema {
    private String nombre;
    public Sistema() {}
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return this.nombre;
    }
}
