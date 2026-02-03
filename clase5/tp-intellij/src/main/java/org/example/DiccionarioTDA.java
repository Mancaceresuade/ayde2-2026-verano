package org.example;

import java.util.ArrayList;

public interface DiccionarioTDA<T,V> {
    void inicializar();

    void agregar(T clave, V valor);

    V recuperar(T clave);

    void eliminar(T clave);

    boolean pertenece(T clave);

    boolean esVacio();

    int cantidad();
    ArrayList<V> getValores();
    ArrayList<T> getClaves();
}
