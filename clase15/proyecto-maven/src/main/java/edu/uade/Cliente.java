package edu.uade;

/**
 * Cliente con nombre y apellido.
 * Orden natural: por apellido, luego por nombre.
 */
public class Cliente implements Comparable<Cliente> {

    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public int compareTo(Cliente otro) {
        int cmp = this.apellido.compareTo(otro.apellido);
        if (cmp != 0) {
            return cmp;
        }
        return this.nombre.compareTo(otro.nombre);
    }
}
