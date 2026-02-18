package edu.uade;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests para GrafoEstatico.
 */
public class GrafoEstaticoTest {

    private iGrafoTDA<Integer> grafo;

    @Before
    public void setUp() {
        grafo = new GrafoEstatico<>();
        grafo.crearGrafo();
    }

    @Test
    public void testAgregarVerticeYObtenerGrado() {
        grafo.agregarVertice(1);
        assertTrue(grafo.existeVertice(1));
        assertEquals(0, grafo.obtenerGrado(1));
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarArista(1, 2);
        assertTrue(grafo.existeArista(1, 2));
        assertTrue(grafo.existeArista(2, 1));
        assertEquals(1, grafo.obtenerGrado(1));
        assertEquals(1, grafo.obtenerGrado(2));
    }

    @Test
    public void testObtenerVecinos() {
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        List<Integer> vecinos = grafo.obtenerVecinos(1);
        assertEquals(2, vecinos.size());
        assertTrue(vecinos.contains(2));
        assertTrue(vecinos.contains(3));
    }

    @Test
    public void testEliminarArista() {
        grafo.agregarArista(1, 2);
        grafo.eliminarArista(1, 2);
        assertFalse(grafo.existeArista(1, 2));
    }

    @Test
    public void testEliminarVerticeConAristas() {
        grafo.agregarArista(1, 2);
        grafo.eliminarVertice(1);
        assertFalse(grafo.existeVertice(1));
        assertEquals(0, grafo.obtenerGrado(2));
    }

    @Test(expected = RuntimeException.class)
    public void testMax200Vertices() {
        for (int i = 0; i < 201; i++) {
            grafo.agregarVertice(i);
        }
    }
}
