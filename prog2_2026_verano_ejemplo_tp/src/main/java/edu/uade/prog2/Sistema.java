package edu.uade.prog2;

public class Sistema {
    private String nombre;

    

    @Override
    public String toString() {
        return this.nombre;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
