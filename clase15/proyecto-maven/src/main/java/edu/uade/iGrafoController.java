package edu.uade;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Interfaz del controlador REST para operaciones sobre el grafo.
 * Refleja los métodos de iGrafoTDA expuestos vía API REST.
 */
public interface iGrafoController {

    /**
     * Crea un grafo vacío.
     */
    ResponseEntity<Void> crearGrafo();

    /**
     * Agrega un vértice v al grafo.
     */
    ResponseEntity<Void> agregarVertice(String v);

    /**
     * Elimina el vértice v y todas sus aristas.
     */
    ResponseEntity<Void> eliminarVertice(String v);

    /**
     * Agrega una arista entre v y w.
     */
    ResponseEntity<Void> agregarArista(String v, String w);

    /**
     * Elimina la arista entre v y w.
     */
    ResponseEntity<Void> eliminarArista(String v, String w);

    /**
     * Indica si el vértice v existe en el grafo.
     */
    ResponseEntity<Boolean> existeVertice(String v);

    /**
     * Indica si existe una arista entre v y w.
     */
    ResponseEntity<Boolean> existeArista(String v, String w);

    /**
     * Retorna la lista de vértices adyacentes a v.
     */
    ResponseEntity<List<String>> obtenerVecinos(String v);

    /**
     * Devuelve el número de aristas conectadas al vértice v (grado).
     */
    ResponseEntity<Integer> obtenerGrado(String v);
}
