package ar.edu.uade;

import org.springframework.stereotype.Component;

/**
 * Implementación estática (basada en arreglos) de un grafo ponderado no
 * dirigido.
 * Soporta hasta MAX_VERTICES vértices (indexados de 0 a MAX_VERTICES-1).
 * Registrado como bean de Spring con scope singleton.
 */
@Component
public class GrafoPonderadoEstatico implements iGrafoPonderadoTDA {

    private static final int MAX_VERTICES = 100;

    /** Indica qué vértices están activos en el grafo. */
    private boolean[] vertices;

    /** Matriz de adyacencia: true si existe arista entre v y w. */
    private boolean[][] aristas;

    /**
     * Matriz de pesos: peso de la arista entre v y w (válido sólo si aristas[v][w]
     * == true).
     */
    private double[][] pesos;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    public GrafoPonderadoEstatico() {
        crearGrafo();
    }

    // -------------------------------------------------------------------------
    // Implementación de la interfaz
    // -------------------------------------------------------------------------

    @Override
    public void crearGrafo() {
        vertices = new boolean[MAX_VERTICES];
        aristas = new boolean[MAX_VERTICES][MAX_VERTICES];
        pesos = new double[MAX_VERTICES][MAX_VERTICES];
    }

    @Override
    public void agregarVertice(int v) {
        validarIndice(v);
        vertices[v] = true;
    }

    @Override
    public void eliminarVertice(int v) {
        validarIndice(v);
        if (!vertices[v])
            return;

        // Eliminar todas las aristas que involucran a v
        for (int i = 0; i < MAX_VERTICES; i++) {
            aristas[v][i] = false;
            aristas[i][v] = false;
            pesos[v][i] = 0;
            pesos[i][v] = 0;
        }
        vertices[v] = false;
    }

    @Override
    public void agregarArista(int v, int w, double peso) {
        validarIndice(v);
        validarIndice(w);
        if (!vertices[v] || !vertices[w]) {
            throw new IllegalArgumentException("Ambos vértices deben existir en el grafo.");
        }
        // Grafo no dirigido: se actualiza en ambos sentidos
        aristas[v][w] = true;
        aristas[w][v] = true;
        pesos[v][w] = peso;
        pesos[w][v] = peso;
    }

    @Override
    public void eliminarArista(int v, int w) {
        validarIndice(v);
        validarIndice(w);
        aristas[v][w] = false;
        aristas[w][v] = false;
        pesos[v][w] = 0;
        pesos[w][v] = 0;
    }

    // -------------------------------------------------------------------------
    // Métodos auxiliares
    // -------------------------------------------------------------------------

    /**
     * Devuelve true si el vértice v existe en el grafo.
     */
    public boolean existeVertice(int v) {
        return v >= 0 && v < MAX_VERTICES && vertices[v];
    }

    /**
     * Devuelve true si existe una arista entre v y w.
     */
    public boolean existeArista(int v, int w) {
        validarIndice(v);
        validarIndice(w);
        return aristas[v][w];
    }

    /**
     * Devuelve el peso de la arista entre v y w.
     * 
     * @throws IllegalArgumentException si la arista no existe.
     */
    public double getPeso(int v, int w) {
        if (!existeArista(v, w)) {
            throw new IllegalArgumentException("No existe arista entre " + v + " y " + w);
        }
        return pesos[v][w];
    }

    /**
     * Valida que el índice esté dentro del rango permitido.
     */
    private void validarIndice(int v) {
        if (v < 0 || v >= MAX_VERTICES) {
            throw new IllegalArgumentException(
                    "Índice fuera de rango: " + v + ". Debe estar entre 0 y " + (MAX_VERTICES - 1));
        }
    }
}
