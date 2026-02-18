package edu.uade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementación dinámica del TDA Grafo usando lista de adyacencia.
 * Estructura dinámica: HashMap + ArrayList para permitir crecimiento sin límite.
 *
 * @param <V> tipo de los vértices (debe tener equals y hashCode correctos)
 */
public class GrafoDinamico<V> implements iGrafoTDA<V> {

    /**
     * Mapa: vértice -> lista de vértices adyacentes.
     * Estructura dinámica que crece según se agregan vértices y aristas.
     */
    private Map<V, List<V>> adyacencia;

    @Override
    public void crearGrafo() {
        adyacencia = new HashMap<>();
    }

    @Override
    public void agregarVertice(V v) {
        if (v == null) {
            throw new RuntimeException("El vértice no puede ser null");
        }
        adyacencia.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void eliminarVertice(V v) {
        if (!existeVertice(v)) {
            return;
        }
        // Eliminar v de las listas de adyacencia de todos sus vecinos
        for (V vecino : new ArrayList<>(adyacencia.get(v))) {
            adyacencia.get(vecino).remove(v);
        }
        adyacencia.remove(v);
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
            adyacencia.get(v).add(w);
            adyacencia.get(w).add(v);
        }
    }

    @Override
    public void eliminarArista(V v, V w) {
        if (existeVertice(v)) {
            adyacencia.get(v).remove(w);
        }
        if (existeVertice(w)) {
            adyacencia.get(w).remove(v);
        }
    }

    @Override
    public boolean existeVertice(V v) {
        return v != null && adyacencia.containsKey(v);
    }

    @Override
    public boolean existeArista(V v, V w) {
        return existeVertice(v) && adyacencia.get(v).contains(w);
    }

    @Override
    public List<V> obtenerVecinos(V v) {
        if (!existeVertice(v)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(adyacencia.get(v));
    }

    @Override
    public int obtenerGrado(V v) {
        if (!existeVertice(v)) {
            return 0;
        }
        return adyacencia.get(v).size();
    }
}
