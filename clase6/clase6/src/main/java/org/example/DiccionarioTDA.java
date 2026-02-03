package org.example;

public interface DiccionarioTDA<T,V> {
    void inicializarDiccionario();
    void agregar(T clave, V valor);
    void eliminar(T clave);
    V recuperar(T clave);
    boolean existeClave(T clave);
    T[] claves();
    V[] valores();
}
