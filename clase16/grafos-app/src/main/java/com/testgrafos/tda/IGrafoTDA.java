package com.testgrafos.tda;

import java.util.Set;

/**
 * Interface para un Grafo Dirigido Ponderado (TDA).
 */
public interface IGrafoTDA {
    /**
     * Inicializa el grafo.
     */
    void inicializarGrafo();

    /**
     * Agrega un vértice al grafo.
     * @param vertice Identificador del vértice.
     */
    void agregarVertice(int vertice);

    /**
     * Elimina un vértice del grafo.
     * @param vertice Identificador del vértice.
     */
    void eliminarVertice(int vertice);

    /**
     * Retorna el conjunto de vértices del grafo.
     * @return Set de enteros con los identificadores.
     */
    Set<Integer> vertices();

    /**
     * Agrega una arista dirigida con un peso entre dos vértices.
     * @param verticeOrigen Vértice de origen.
     * @param verticeDestino Vértice de destino.
     * @param peso Peso de la arista.
     */
    void agregarArista(int verticeOrigen, int verticeDestino, int peso);

    /**
     * Elimina una arista dirigida entre dos vértices.
     * @param verticeOrigen Vértice de origen.
     * @param verticeDestino Vértice de destino.
     */
    void eliminarArista(int verticeOrigen, int verticeDestino);

    /**
     * Retorna el peso de una arista entre dos vértices.
     * @param verticeOrigen Vértice de origen.
     * @param verticeDestino Vértice de destino.
     * @return El peso de la arista.
     */
    int pesoArista(int verticeOrigen, int verticeDestino);

    /**
     * Indica si existe una arista entre dos vértices.
     * @param verticeOrigen Vértice de origen.
     * @param verticeDestino Vértice de destino.
     * @return true si existe la arista, false en caso contrario.
     */
    boolean existeArista(int verticeOrigen, int verticeDestino);

    /**
     * Realiza un recorrido en anchura (BFS) desde un vértice inicial.
     * @param verticeInicial Vértice de inicio del recorrido.
     * @return Lista de vértices visitados en orden.
     */
    java.util.List<Integer> bfs(int verticeInicial);

    /**
     * Realiza un recorrido en profundidad (DFS) desde un vértice inicial.
     * @param verticeInicial Vértice de inicio del recorrido.
     * @return Lista de vértices visitados en orden.
     */
    java.util.List<Integer> dfs(int verticeInicial);
}
