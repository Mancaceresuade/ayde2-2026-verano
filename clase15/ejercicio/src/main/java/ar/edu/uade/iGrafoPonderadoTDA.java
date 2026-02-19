package ar.edu.uade;

/**
 * Interface que representa un Grafo Ponderado.
 * Las aristas tienen un peso (peso) asociado.
 */
public interface iGrafoPonderadoTDA {

    /**
     * Crea un grafo vacío (reinicia el estado del grafo).
     */
    void crearGrafo();

    /**
     * Agrega un vértice v al grafo.
     * 
     * @param v el vértice a agregar
     */
    void agregarVertice(int v);

    /**
     * Elimina el vértice v y todas sus aristas asociadas.
     * 
     * @param v el vértice a eliminar
     */
    void eliminarVertice(int v);

    /**
     * Agrega una arista ponderada entre los vértices v y w.
     * 
     * @param v    vértice origen
     * @param w    vértice destino
     * @param peso peso de la arista
     */
    void agregarArista(int v, int w, double peso);

    /**
     * Elimina la arista entre los vértices v y w.
     * 
     * @param v vértice origen
     * @param w vértice destino
     */
    void eliminarArista(int v, int w);
}
