package org.example;

public interface ListaTDA<T> {

    void inicializar();
    void agregar(T elemento);
    void eliminar(int indice);
    boolean contiene(T elemento);
    int tamaño();
    T obtener(int indice);

}
