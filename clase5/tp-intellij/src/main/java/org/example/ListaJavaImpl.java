package org.example;

    public class ListaJavaImpl<T> implements ListaTDA<T>{
    private java.util.List<T> lista;

    @Override
    public void inicializar() {
        lista = new java.util.ArrayList<>();
    }

    @Override
    public void agregar(T elemento) {
        lista.add(elemento);
    }

    @Override
    public void eliminar(int indice) {
        lista.remove(indice);
    }

    @Override
    public boolean contiene(T elemento) {
        return lista.contains(elemento);
    }

    @Override
    public int tamaño() {
        return lista.size();
    }

    @Override
    public T obtener(int indice) {
        return lista.get(indice);
    }
}
