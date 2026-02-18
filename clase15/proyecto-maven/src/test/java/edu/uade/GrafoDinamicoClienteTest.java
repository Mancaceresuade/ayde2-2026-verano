package edu.uade;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests para GrafoDinamico usando Cliente como tipo de vértice.
 */
public class GrafoDinamicoClienteTest {

    private iGrafoTDA<Cliente> grafo;
    private Cliente clienteA;
    private Cliente clienteB;
    private Cliente clienteC;

    @Before
    public void setUp() {
        grafo = new GrafoDinamico<>();
        grafo.crearGrafo();
        clienteA = new Cliente("Juan", "Pérez");
        clienteB = new Cliente("Ana", "García");
        clienteC = new Cliente("Carlos", "López");
    }

    @Test
    public void testCrearGrafo() {
        assertFalse(grafo.existeVertice(clienteA));
        assertEquals(0, grafo.obtenerGrado(clienteA));
    }

    @Test
    public void testAgregarVertice() {
        grafo.agregarVertice(clienteA);
        grafo.agregarVertice(clienteB);
        assertTrue(grafo.existeVertice(clienteA));
        assertTrue(grafo.existeVertice(clienteB));
    }

    @Test(expected = RuntimeException.class)
    public void testAgregarVerticeNullLanzaExcepcion() {
        grafo.agregarVertice(null);
    }

    @Test
    public void testEliminarVertice() {
        grafo.agregarVertice(clienteA);
        grafo.eliminarVertice(clienteA);
        assertFalse(grafo.existeVertice(clienteA));
    }

    @Test
    public void testEliminarVerticeConAristas() {
        grafo.agregarArista(clienteA, clienteB);
        grafo.eliminarVertice(clienteA);
        assertFalse(grafo.existeVertice(clienteA));
        assertTrue(grafo.existeVertice(clienteB));
        assertFalse(grafo.existeArista(clienteA, clienteB));
        assertEquals(0, grafo.obtenerGrado(clienteB));
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarArista(clienteA, clienteB);
        assertTrue(grafo.existeArista(clienteA, clienteB));
        assertTrue(grafo.existeArista(clienteB, clienteA));
    }

    @Test
    public void testAgregarAristaCreaVertices() {
        grafo.agregarArista(clienteA, clienteB);
        assertTrue(grafo.existeVertice(clienteA));
        assertTrue(grafo.existeVertice(clienteB));
    }

    @Test
    public void testEliminarArista() {
        grafo.agregarArista(clienteA, clienteB);
        grafo.eliminarArista(clienteA, clienteB);
        assertFalse(grafo.existeArista(clienteA, clienteB));
        assertFalse(grafo.existeArista(clienteB, clienteA));
    }

    @Test
    public void testObtenerVecinos() {
        grafo.agregarArista(clienteA, clienteB);
        grafo.agregarArista(clienteA, clienteC);
        List<Cliente> vecinos = grafo.obtenerVecinos(clienteA);
        assertEquals(2, vecinos.size());
        assertTrue(vecinos.contains(clienteB));
        assertTrue(vecinos.contains(clienteC));
    }

    @Test
    public void testObtenerVecinosVerticeInexistente() {
        Cliente inexistente = new Cliente("X", "Y");
        List<Cliente> vecinos = grafo.obtenerVecinos(inexistente);
        assertTrue(vecinos.isEmpty());
    }

    @Test
    public void testObtenerGrado() {
        grafo.agregarArista(clienteA, clienteB);
        grafo.agregarArista(clienteA, clienteC);
        assertEquals(2, grafo.obtenerGrado(clienteA));
    }

    @Test
    public void testObtenerGradoVerticeInexistente() {
        Cliente inexistente = new Cliente("X", "Y");
        assertEquals(0, grafo.obtenerGrado(inexistente));
    }

    @Test
    public void testGrafoClientesRelacionados() {
        grafo.agregarArista(clienteA, clienteB);
        grafo.agregarArista(clienteB, clienteC);
        assertTrue(grafo.existeArista(clienteA, clienteB));
        assertTrue(grafo.existeArista(clienteB, clienteC));
        assertFalse(grafo.existeArista(clienteA, clienteC));
        assertEquals(1, grafo.obtenerGrado(clienteA));
        assertEquals(2, grafo.obtenerGrado(clienteB));
        assertEquals(1, grafo.obtenerGrado(clienteC));
    }
}
