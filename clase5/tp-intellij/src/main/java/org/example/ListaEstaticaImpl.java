package org.example;

public class ListaEstaticaImpl <T> implements ListaTDA<T>{
    private T[] lista;

    @Override
    public void inicializar() {
        lista = (T[]) new Object[100]; // Tamaño fijo de 100 elementos
    }

    @Override
    public void agregar(T elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar(int indice) {

    }

    @Override
    public boolean contiene(T elemento) {
        return false;
    }

    @Override
    public int tamaño() {
        return 0;
    }

    @Override
    public T obtener(int indice) {
        return null;
    }
}
