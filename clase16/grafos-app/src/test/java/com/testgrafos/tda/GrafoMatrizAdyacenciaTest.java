package com.testgrafos.tda;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

public class GrafoMatrizAdyacenciaTest {
    private IGrafoTDA grafo;

    @Before
    public void setUp() {
        grafo = new GrafoMatrizAdyacencia();
        grafo.inicializarGrafo();
    }

    @Test
    public void testAgregarYVertices() {
        grafo.agregarVertice(10);
        grafo.agregarVertice(20);
        Set<Integer> vertices = grafo.vertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains(10));
        assertTrue(vertices.contains(20));
    }

    @Test
    public void testEliminarVertice() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(1, 2, 10);
        grafo.agregarArista(3, 1, 5);
        
        grafo.eliminarVertice(1);
        
        Set<Integer> vertices = grafo.vertices();
        assertEquals(2, vertices.size());
        assertFalse(vertices.contains(1));
        assertFalse(grafo.existeArista(1, 2));
        assertFalse(grafo.existeArista(3, 1));
    }

    @Test
    public void testAristasYPesos() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2, 100);
        
        assertTrue(grafo.existeArista(1, 2));
        assertEquals(100, grafo.pesoArista(1, 2));
        assertFalse(grafo.existeArista(2, 1));
    }

    @Test
    public void testEliminarArista() {
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);
        grafo.agregarArista(5, 6, 42);
        assertTrue(grafo.existeArista(5, 6));
        
        grafo.eliminarArista(5, 6);
        assertFalse(grafo.existeArista(5, 6));
        assertEquals(0, grafo.pesoArista(5, 6));
    }

    @Test
    public void testLimiteDeNodos() {
        // Test simple de múltiples inserciones para verificar que el mapeo funciona
        for (int i = 0; i < 50; i++) {
            grafo.agregarVertice(i);
        }
        assertEquals(50, grafo.vertices().size());
        
        grafo.agregarArista(0, 49, 999);
        assertEquals(999, grafo.pesoArista(0, 49));
    }

    @Test
    public void testBFS() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        
        java.util.List<Integer> resultado = grafo.bfs(1);
        assertEquals(3, resultado.size());
        assertEquals(java.util.Arrays.asList(1, 2, 3), resultado);
    }

    @Test
    public void testDFS() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 3, 1);
        
        java.util.List<Integer> resultado = grafo.dfs(1);
        assertEquals(3, resultado.size());
        assertEquals(java.util.Arrays.asList(1, 2, 3), resultado);
    }
}
