package com.testgrafos.tda;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Implementación de IGrafoTDA utilizando Listas de Adyacencia.
 * Se utiliza un Map donde la clave es el vértice origen y el valor es otro Map
 * que contiene los destinos y sus respectivos pesos.
 */
public class GrafoListaAdyacencia implements IGrafoTDA {
    private Map<Integer, Map<Integer, Integer>> adyacencias;

    @Override
    public void inicializarGrafo() {
        adyacencias = new HashMap<>();
    }

    @Override
    public void agregarVertice(int vertice) {
        if (!adyacencias.containsKey(vertice)) {
            adyacencias.put(vertice, new HashMap<>());
        }
    }

    @Override
    public void eliminarVertice(int vertice) {
        // Eliminar el vértice y sus aristas salientes
        adyacencias.remove(vertice);
        
        // Eliminar todas las aristas entrantes a este vértice desde otros nodos
        for (Map<Integer, Integer> vecinos : adyacencias.values()) {
            vecinos.remove(vertice);
        }
    }

    @Override
    public Set<Integer> vertices() {
        return adyacencias.keySet();
    }

    @Override
    public void agregarArista(int verticeOrigen, int verticeDestino, int peso) {
        if (adyacencias.containsKey(verticeOrigen) && adyacencias.containsKey(verticeDestino)) {
            adyacencias.get(verticeOrigen).put(verticeDestino, peso);
        }
    }

    @Override
    public void eliminarArista(int verticeOrigen, int verticeDestino) {
        if (adyacencias.containsKey(verticeOrigen)) {
            adyacencias.get(verticeOrigen).remove(verticeDestino);
        }
    }

    @Override
    public int pesoArista(int verticeOrigen, int verticeDestino) {
        if (existeArista(verticeOrigen, verticeDestino)) {
            return adyacencias.get(verticeOrigen).get(verticeDestino);
        }
        return 0; // O podrías lanzar una excepción si la arista no existe
    }

    @Override
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        return adyacencias.containsKey(verticeOrigen) && 
               adyacencias.get(verticeOrigen).containsKey(verticeDestino);
    }

    @Override
    public java.util.List<Integer> bfs(int verticeInicial) {
        java.util.List<Integer> visitados = new java.util.ArrayList<>();
        if (!adyacencias.containsKey(verticeInicial)) {
            return visitados;
        }

        java.util.Queue<Integer> cola = new java.util.LinkedList<>();
        java.util.Set<Integer> marcado = new java.util.HashSet<>();

        cola.add(verticeInicial);
        marcado.add(verticeInicial);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            visitados.add(actual);

            Map<Integer, Integer> vecinos = adyacencias.get(actual);
            if (vecinos != null) {
                for (Integer vecino : vecinos.keySet()) {
                    if (!marcado.contains(vecino)) {
                        marcado.add(vecino);
                        cola.add(vecino);
                    }
                }
            }
        }
        return visitados;
    }

    @Override
    public java.util.List<Integer> dfs(int verticeInicial) {
        java.util.List<Integer> visitados = new java.util.ArrayList<>();
        if (!adyacencias.containsKey(verticeInicial)) {
            return visitados;
        }
        dfsRecursivo(verticeInicial, new java.util.HashSet<>(), visitados);
        return visitados;
    }

    private void dfsRecursivo(int actual, java.util.Set<Integer> marcado, java.util.List<Integer> visitados) {
        marcado.add(actual);
        visitados.add(actual);

        Map<Integer, Integer> vecinos = adyacencias.get(actual);
        if (vecinos != null) {
            for (Integer vecino : vecinos.keySet()) {
                if (!marcado.contains(vecino)) {
                    dfsRecursivo(vecino, marcado, visitados);
                }
            }
        }
    }
}
