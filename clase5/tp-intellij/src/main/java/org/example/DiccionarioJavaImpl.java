package org.example;

import java.util.ArrayList;

public class DiccionarioJavaImpl<C,V> implements DiccionarioTDA<C,V>{



    @Override
    public void inicializar() {

    }

    @Override
    public void agregar(C clave, V valor) {

    }

    @Override
    public V recuperar(C clave) {
        return null;
    }

    @Override
    public void eliminar(C clave) {

    }

    @Override
    public boolean pertenece(C clave) {
        return false;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public int cantidad() {
        return 0;
    }

    @Override
    public ArrayList<V> getValores() {
        return null;
    }

    @Override
    public ArrayList<C> getClaves() {
        return null;
    }
}
