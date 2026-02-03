package org.example;

public class DiccionarioImplEstatico<T,V> implements DiccionarioTDA<T,V> {
    // opcion, conjunto de TAD par ordenado
    T[] claves;
    V[] valores;
    int cantClaves;
    @Override
    public void inicializarDiccionario() {

    }

    @Override
    public void agregar(T clave, V valor) {

    }

    @Override
    public void eliminar(T clave) {

    }

    @Override
    public V recuperar(T clave) {
        return null;
    }

    @Override
    public boolean existeClave(T clave) {
        return false;
    }

    @Override
    public T[] claves() {
        return null;
    }

    @Override
    public V[] valores() {
        return null;
    }
}
