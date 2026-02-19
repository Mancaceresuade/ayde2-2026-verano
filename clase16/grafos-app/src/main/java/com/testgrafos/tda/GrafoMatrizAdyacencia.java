package com.testgrafos.tda;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementación de IGrafoTDA utilizando Matriz de Adyacencia.
 * Permite hasta un máximo de vértices definido inicialmente.
 */
public class GrafoMatrizAdyacencia implements IGrafoTDA {
    private int[][] matriz;
    private int[] nodos; // Mapeo de índice a Identificador de Vértice
    private Map<Integer, Integer> mapping; // Mapeo de Identificador a Índice
    private int cantidadNodos;
    private static final int MAX_NODOS = 100;

    @Override
    public void inicializarGrafo() {
        matriz = new int[MAX_NODOS][MAX_NODOS];
        nodos = new int[MAX_NODOS];
        mapping = new HashMap<>();
        cantidadNodos = 0;
        
        // Inicializar matriz con 0 (sin aristas)
        for (int i = 0; i < MAX_NODOS; i++) {
            for (int j = 0; j < MAX_NODOS; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    @Override
    public void agregarVertice(int vertice) {
        if (!mapping.containsKey(vertice) && cantidadNodos < MAX_NODOS) {
            mapping.put(vertice, cantidadNodos);
            nodos[cantidadNodos] = vertice;
            cantidadNodos++;
        }
    }

    @Override
    public void eliminarVertice(int vertice) {
        if (mapping.containsKey(vertice)) {
            int indiceAEliminar = mapping.get(vertice);
            
            // Eliminar aristas relacionadas en la matriz
            for (int i = 0; i < cantidadNodos; i++) {
                matriz[i][indiceAEliminar] = 0;
                matriz[indiceAEliminar][i] = 0;
            }

            // Reorganizar para no dejar huecos (mover el último a la posición del eliminado)
            if (indiceAEliminar < cantidadNodos - 1) {
                int ultimoNodo = nodos[cantidadNodos - 1];
                
                // Mover filas y columnas en la matriz
                for (int i = 0; i < cantidadNodos; i++) {
                    matriz[i][indiceAEliminar] = matriz[i][cantidadNodos - 1];
                    matriz[indiceAEliminar][i] = matriz[cantidadNodos - 1][i];
                }
                
                nodos[indiceAEliminar] = ultimoNodo;
                mapping.put(ultimoNodo, indiceAEliminar);
            }
            
            mapping.remove(vertice);
            cantidadNodos--;
        }
    }

    @Override
    public Set<Integer> vertices() {
        return new HashSet<>(mapping.keySet());
    }

    @Override
    public void agregarArista(int verticeOrigen, int verticeDestino, int peso) {
        if (mapping.containsKey(verticeOrigen) && mapping.containsKey(verticeDestino)) {
            int i = mapping.get(verticeOrigen);
            int j = mapping.get(verticeDestino);
            matriz[i][j] = peso;
        }
    }

    @Override
    public void eliminarArista(int verticeOrigen, int verticeDestino) {
        if (mapping.containsKey(verticeOrigen) && mapping.containsKey(verticeDestino)) {
            int i = mapping.get(verticeOrigen);
            int j = mapping.get(verticeDestino);
            matriz[i][j] = 0;
        }
    }

    @Override
    public int pesoArista(int verticeOrigen, int verticeDestino) {
        if (existeArista(verticeOrigen, verticeDestino)) {
            int i = mapping.get(verticeOrigen);
            int j = mapping.get(verticeDestino);
            return matriz[i][j];
        }
        return 0;
    }

    @Override
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        if (mapping.containsKey(verticeOrigen) && mapping.containsKey(verticeDestino)) {
            int i = mapping.get(verticeOrigen);
            int j = mapping.get(verticeDestino);
            return matriz[i][j] != 0;
        }
        return false;
    }

    @Override
    public java.util.List<Integer> bfs(int verticeInicial) {
        java.util.List<Integer> resultado = new java.util.ArrayList<>();
        if (!mapping.containsKey(verticeInicial)) {
            return resultado;
        }

        java.util.Queue<Integer> cola = new java.util.LinkedList<>();
        java.util.Set<Integer> visitados = new java.util.HashSet<>();

        cola.add(verticeInicial);
        visitados.add(verticeInicial);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            resultado.add(actual);

            int indiceActual = mapping.get(actual);
            for (int j = 0; j < cantidadNodos; j++) {
                if (matriz[indiceActual][j] != 0) {
                    int vecino = nodos[j];
                    if (!visitados.contains(vecino)) {
                        visitados.add(vecino);
                        cola.add(vecino);
                    }
                }
            }
        }
        return resultado;
    }

    @Override
    public java.util.List<Integer> dfs(int verticeInicial) {
        java.util.List<Integer> resultado = new java.util.ArrayList<>();
        if (!mapping.containsKey(verticeInicial)) {
            return resultado;
        }
        dfsRecursivo(verticeInicial, new java.util.HashSet<>(), resultado);
        return resultado;
    }

    private void dfsRecursivo(int actual, java.util.Set<Integer> visitados, java.util.List<Integer> resultado) {
        visitados.add(actual);
        resultado.add(actual);

        int indiceActual = mapping.get(actual);
        for (int j = 0; j < cantidadNodos; j++) {
            if (matriz[indiceActual][j] != 0) {
                int vecino = nodos[j];
                if (!visitados.contains(vecino)) {
                    dfsRecursivo(vecino, visitados, resultado);
                }
            }
        }
    }
}
