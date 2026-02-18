package edu.uade;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests para GrafoDinamico.
 */
public class GrafoDinamicoTest {

    private iGrafoTDA<Integer> grafo;

    @Before
    public void setUp() {
        grafo = new GrafoDinamico<>();
        grafo.crearGrafo();
    }

    @Test
    public void testCrearGrafo() {
        assertFalse(grafo.existeVertice(1));
        assertEquals(0, grafo.obtenerGrado(1));
    }

    @Test
    public void testAgregarVertice() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        assertTrue(grafo.existeVertice(1));
        assertTrue(grafo.existeVertice(2));
    }

    @Test(expected = RuntimeException.class)
    public void testAgregarVerticeNullLanzaExcepcion() {
        grafo.agregarVertice(null);
    }

    @Test
    public void testEliminarVertice() {
        grafo.agregarVertice(1);
        grafo.eliminarVertice(1);
        assertFalse(grafo.existeVertice(1));
    }

    @Test
    public void testEliminarVerticeConAristas() {
        grafo.agregarArista(1, 2);
        grafo.eliminarVertice(1);
        assertFalse(grafo.existeVertice(1));
        assertTrue(grafo.existeVertice(2));
        assertFalse(grafo.existeArista(1, 2));
        assertEquals(0, grafo.obtenerGrado(2));
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarArista(1, 2);
        assertTrue(grafo.existeArista(1, 2));
        assertTrue(grafo.existeArista(2, 1));
    }

    @Test
    public void testAgregarAristaCreaVertices() {
        grafo.agregarArista(1, 2);
        assertTrue(grafo.existeVertice(1));
        assertTrue(grafo.existeVertice(2));
    }

    @Test
    public void testEliminarArista() {
        grafo.agregarArista(1, 2);
        grafo.eliminarArista(1, 2);
        assertFalse(grafo.existeArista(1, 2));
        assertFalse(grafo.existeArista(2, 1));
    }

    @Test
    public void testExisteVertice() {
        assertFalse(grafo.existeVertice(1));
        grafo.agregarVertice(1);
        assertTrue(grafo.existeVertice(1));
    }

    @Test
    public void testExisteArista() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        assertFalse(grafo.existeArista(1, 2));
        grafo.agregarArista(1, 2);
        assertTrue(grafo.existeArista(1, 2));
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
    public void testObtenerVecinosVerticeInexistente() {
        List<Integer> vecinos = grafo.obtenerVecinos(99);
        assertTrue(vecinos.isEmpty());
    }

    @Test
    public void testObtenerGrado() {
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);
        assertEquals(2, grafo.obtenerGrado(1));
    }

    @Test
    public void testObtenerGradoVerticeInexistente() {
        assertEquals(0, grafo.obtenerGrado(99));
    }

    @Test
    public void testAristaDuplicadaNoSeAgregaDosVeces() {
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 2);
        assertEquals(1, grafo.obtenerGrado(1));
    }
}
