package edu.uade;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación estática del TDA Grafo.
 * Máximo 200 vértices. Usa matriz de adyacencia de tamaño fijo.
 *
 * @param <V> tipo de los vértices (debe tener equals correcto)
 */
public class GrafoEstatico<V> implements iGrafoTDA<V> {

    private static final int MAX_VERTICES = 200;

    private final Object[] vertices;
    private final boolean[][] adyacencia;
    private int cantVertices;

    public GrafoEstatico() {
        vertices = new Object[MAX_VERTICES];
        adyacencia = new boolean[MAX_VERTICES][MAX_VERTICES];
    }

    @Override
    public void crearGrafo() {
        for (int i = 0; i < MAX_VERTICES; i++) {
            vertices[i] = null;
        }
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adyacencia[i][j] = false;
            }
        }
        cantVertices = 0;
    }

    @Override
    public void agregarVertice(V v) {
        if (v == null) {
            throw new RuntimeException("El vértice no puede ser null");
        }
        int idx = buscarIndice(v);
        if (idx >= 0) {
            return;
        }
        if (cantVertices >= MAX_VERTICES) {
            throw new RuntimeException("No se pueden agregar más de " + MAX_VERTICES + " vértices");
        }
        int libre = buscarPosicionLibre();
        vertices[libre] = v;
        cantVertices++;
    }

    @Override
    public void eliminarVertice(V v) {
        int idx = buscarIndice(v);
        if (idx < 0) {
            return;
        }
        for (int j = 0; j < MAX_VERTICES; j++) {
            adyacencia[idx][j] = false;
            adyacencia[j][idx] = false;
        }
        vertices[idx] = null;
        cantVertices--;
    }

    @Override
    public void agregarArista(V v, V w) {
        if (!existeVertice(v)) {
            agregarVertice(v);
        }
        if (!existeVertice(w)) {
            agregarVertice(w);
        }
        int i = buscarIndice(v);
        int j = buscarIndice(w);
        adyacencia[i][j] = true;
        adyacencia[j][i] = true;
    }

    @Override
    public void eliminarArista(V v, V w) {
        int i = buscarIndice(v);
        int j = buscarIndice(w);
        if (i >= 0 && j >= 0) {
            adyacencia[i][j] = false;
            adyacencia[j][i] = false;
        }
    }

    @Override
    public boolean existeVertice(V v) {
        return buscarIndice(v) >= 0;
    }

    @Override
    public boolean existeArista(V v, V w) {
        int i = buscarIndice(v);
        int j = buscarIndice(w);
        return i >= 0 && j >= 0 && adyacencia[i][j];
    }

    @Override
    public List<V> obtenerVecinos(V v) {
        List<V> resultado = new ArrayList<>();
        int i = buscarIndice(v);
        if (i >= 0) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                if (adyacencia[i][j] && vertices[j] != null) {
                    resultado.add((V) vertices[j]);
                }
            }
        }
        return resultado;
    }

    @Override
    public int obtenerGrado(V v) {
        int grado = 0;
        int i = buscarIndice(v);
        if (i >= 0) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                if (adyacencia[i][j]) {
                    grado++;
                }
            }
        }
        return grado;
    }

    private int buscarIndice(V v) {
        if (v == null) {
            return -1;
        }
        for (int i = 0; i < MAX_VERTICES; i++) {
            if (vertices[i] != null && v.equals(vertices[i])) {
                return i;
            }
        }
        return -1;
    }

    private int buscarPosicionLibre() {
        for (int i = 0; i < MAX_VERTICES; i++) {
            if (vertices[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
