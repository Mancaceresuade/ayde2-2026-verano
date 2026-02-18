package edu.uade;

import java.util.List;

/**
 * Interfaz TDA (Tipo de Dato Abstracto) para un grafo.
 *
 * @param <V> tipo de los vértices
 */
public interface iGrafoTDA<V> {

    /**
     * Crea un grafo vacío.
     */
    void crearGrafo();

    /**
     * Agrega un vértice v al grafo.
     *
     * @param v vértice a agregar
     */
    void agregarVertice(V v);

    /**
     * Elimina el vértice v y todas sus aristas.
     *
     * @param v vértice a eliminar
     */
    void eliminarVertice(V v);

    /**
     * Agrega una arista entre v y w.
     *
     * @param v primer vértice
     * @param w segundo vértice
     */
    void agregarArista(V v, V w);

    /**
     * Elimina la arista entre v y w.
     *
     * @param v primer vértice
     * @param w segundo vértice
     */
    void eliminarArista(V v, V w);

    /**
     * Indica si el vértice v existe en el grafo.
     *
     * @param v vértice a consultar
     * @return true si v existe, false en caso contrario
     */
    boolean existeVertice(V v);

    /**
     * Indica si existe una arista entre v y w.
     *
     * @param v primer vértice
     * @param w segundo vértice
     * @return true si existe la arista, false en caso contrario
     */
    boolean existeArista(V v, V w);

    /**
     * Retorna la lista de vértices adyacentes a v.
     *
     * @param v vértice del cual obtener vecinos
     * @return lista de vértices adyacentes a v (no null)
     */
    List<V> obtenerVecinos(V v);

    /**
     * Devuelve el número de aristas conectadas al vértice v (grado del vértice).
     *
     * @param v vértice
     * @return grado de v
     */
    int obtenerGrado(V v);
}
