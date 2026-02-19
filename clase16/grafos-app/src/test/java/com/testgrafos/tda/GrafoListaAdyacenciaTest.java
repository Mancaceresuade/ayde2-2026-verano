package com.testgrafos.tda;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;

public class GrafoListaAdyacenciaTest {
    private IGrafoTDA grafo;

    @Before
    public void setUp() {
        grafo = new GrafoListaAdyacencia();
        grafo.inicializarGrafo();
    }

    @Test
    public void testAgregarYVertices() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        Set<Integer> vertices = grafo.vertices();
        assertEquals(2, vertices.size());
        assertTrue(vertices.contains(1));
        assertTrue(vertices.contains(2));
    }

    @Test
    public void testEliminarVertice() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2, 10);
        grafo.eliminarVertice(1);
        
        Set<Integer> vertices = grafo.vertices();
        assertEquals(1, vertices.size());
        assertFalse(vertices.contains(1));
        assertFalse(grafo.existeArista(1, 2));
    }

    @Test
    public void testAristas() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2, 50);
        
        assertTrue(grafo.existeArista(1, 2));
        assertEquals(50, grafo.pesoArista(1, 2));
        assertFalse(grafo.existeArista(2, 1)); // Dirigido
    }

    @Test
    public void testEliminarArista() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2, 50);
        grafo.eliminarArista(1, 2);
        
        assertFalse(grafo.existeArista(1, 2));
    }

    @Test
    public void testPesoAristaInexistente() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        assertEquals(0, grafo.pesoArista(1, 2));
    }

    @Test
    public void testBFS() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 1);
        grafo.agregarArista(2, 4, 1);
        
        java.util.List<Integer> resultado = grafo.bfs(1);
        
        assertEquals(4, resultado.size());
        assertEquals(Integer.valueOf(1), resultado.get(0));
        // En BFS, 2 y 3 deberían estar antes que 4
        assertTrue(resultado.indexOf(2) < resultado.indexOf(4));
        assertTrue(resultado.indexOf(3) < resultado.indexOf(4));
    }

    @Test
    public void testDFS() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(2, 4, 1);
        grafo.agregarArista(1, 3, 1);
        
        java.util.List<Integer> resultado = grafo.dfs(1);
        
        assertEquals(4, resultado.size());
        assertEquals(Integer.valueOf(1), resultado.get(0));
        // En DFS, si va por 2, debe visitar 4 antes que 3
        if (resultado.get(1) == 2) {
            assertEquals(Integer.valueOf(4), resultado.get(2));
            assertEquals(Integer.valueOf(3), resultado.get(3));
        } else {
            assertEquals(Integer.valueOf(3), resultado.get(1));
            assertEquals(Integer.valueOf(2), resultado.get(2));
            assertEquals(Integer.valueOf(4), resultado.get(3));
        }
    }
}
