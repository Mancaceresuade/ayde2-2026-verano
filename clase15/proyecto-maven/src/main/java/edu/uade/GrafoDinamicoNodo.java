package edu.uade;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación dinámica del TDA Grafo usando listas enlazadas con Nodo.
 * Cada vértice tiene una lista de vecinos representada como Nodo enlazados.
 *
 * @param <V> tipo de los vértices (debe tener equals correcto para búsquedas)
 */
public class GrafoDinamicoNodo<V> implements iGrafoTDA<V> {

    /**
     * Celda que almacena un vértice y la cabeza de su lista de vecinos.
     */
    private static class CeldaVertice<V> {
        V vertice;
        Nodo<V> cabezaVecinos;

        CeldaVertice(V vertice, Nodo<V> cabezaVecinos) {
            this.vertice = vertice;
            this.cabezaVecinos = cabezaVecinos;
        }
    }

    /**
     * Cabeza de la lista de vértices del grafo.
     */
    private Nodo<CeldaVertice<V>> cabezaVertices;

    @Override
    public void crearGrafo() {
        cabezaVertices = null;
    }

    @Override
    public void agregarVertice(V v) {
        if (v == null) {
            throw new RuntimeException("El vértice no puede ser null");
        }
        if (!existeVertice(v)) {
            CeldaVertice<V> celda = new CeldaVertice<>(v, null);
            cabezaVertices = new Nodo<>(celda, cabezaVertices);
        }
    }

    @Override
    public void eliminarVertice(V v) {
        CeldaVertice<V> celda = buscarCelda(v);
        if (celda == null) {
            return;
        }
        // Eliminar v de la lista de vecinos de todos sus vecinos
        Nodo<V> actual = celda.cabezaVecinos;
        while (actual != null) {
            eliminarDeListaVecinos(actual.getElemento(), v);
            actual = actual.getSiguiente();
        }
        // Eliminar la celda de la lista de vértices
        removerCelda(v);
    }

    @Override
    public void agregarArista(V v, V w) {
        if (!existeVertice(v)) {
            agregarVertice(v);
        }
        if (!existeVertice(w)) {
            agregarVertice(w);
        }
        if (!existeArista(v, w)) {
            agregarAListaVecinos(v, w);
            agregarAListaVecinos(w, v);
        }
    }

    @Override
    public void eliminarArista(V v, V w) {
        eliminarDeListaVecinos(v, w);
        eliminarDeListaVecinos(w, v);
    }

    @Override
    public boolean existeVertice(V v) {
        return buscarCelda(v) != null;
    }

    @Override
    public boolean existeArista(V v, V w) {
        return estaEnListaVecinos(v, w);
    }

    @Override
    public List<V> obtenerVecinos(V v) {
        List<V> resultado = new ArrayList<>();
        CeldaVertice<V> celda = buscarCelda(v);
        if (celda != null) {
            Nodo<V> actual = celda.cabezaVecinos;
            while (actual != null) {
                resultado.add(actual.getElemento());
                actual = actual.getSiguiente();
            }
        }
        return resultado;
    }

    @Override
    public int obtenerGrado(V v) {
        int grado = 0;
        CeldaVertice<V> celda = buscarCelda(v);
        if (celda != null) {
            Nodo<V> actual = celda.cabezaVecinos;
            while (actual != null) {
                grado++;
                actual = actual.getSiguiente();
            }
        }
        return grado;
    }

    private CeldaVertice<V> buscarCelda(V v) {
        Nodo<CeldaVertice<V>> actual = cabezaVertices;
        while (actual != null) {
            if (v.equals(actual.getElemento().vertice)) {
                return actual.getElemento();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    private void agregarAListaVecinos(V vertice, V vecino) {
        CeldaVertice<V> celda = buscarCelda(vertice);
        if (celda != null) {
            celda.cabezaVecinos = new Nodo<>(vecino, celda.cabezaVecinos);
        }
    }

    private void eliminarDeListaVecinos(V vertice, V vecino) {
        CeldaVertice<V> celda = buscarCelda(vertice);
        if (celda == null) {
            return;
        }
        Nodo<V> cabeza = celda.cabezaVecinos;
        if (cabeza == null) {
            return;
        }
        if (vecino.equals(cabeza.getElemento())) {
            celda.cabezaVecinos = cabeza.getSiguiente();
            return;
        }
        Nodo<V> ant = cabeza;
        Nodo<V> actual = cabeza.getSiguiente();
        while (actual != null) {
            if (vecino.equals(actual.getElemento())) {
                ant.setSiguiente(actual.getSiguiente());
                return;
            }
            ant = actual;
            actual = actual.getSiguiente();
        }
    }

    private boolean estaEnListaVecinos(V vertice, V vecino) {
        CeldaVertice<V> celda = buscarCelda(vertice);
        if (celda == null) {
            return false;
        }
        Nodo<V> actual = celda.cabezaVecinos;
        while (actual != null) {
            if (vecino.equals(actual.getElemento())) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    private void removerCelda(V v) {
        if (cabezaVertices == null) {
            return;
        }
        if (v.equals(cabezaVertices.getElemento().vertice)) {
            cabezaVertices = cabezaVertices.getSiguiente();
            return;
        }
        Nodo<CeldaVertice<V>> ant = cabezaVertices;
        Nodo<CeldaVertice<V>> actual = cabezaVertices.getSiguiente();
        while (actual != null) {
            if (v.equals(actual.getElemento().vertice)) {
                ant.setSiguiente(actual.getSiguiente());
                return;
            }
            ant = actual;
            actual = actual.getSiguiente();
        }
    }
}
