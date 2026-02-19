package ar.edu.uade;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GrafoPonderadoEstaticoTest {

    private GrafoPonderadoEstatico grafo;

    @Before
    public void setUp() {
        grafo = new GrafoPonderadoEstatico();
        grafo.crearGrafo();
    }

    // -------------------------------------------------------------------------
    // crearGrafo
    // -------------------------------------------------------------------------

    @Test
    public void crearGrafo_grafoVacio_sinVertices() {
        for (int i = 0; i < 100; i++) {
            assertFalse("Vértice " + i + " no debería existir", grafo.existeVertice(i));
        }
    }

    @Test
    public void crearGrafo_reinicia_grafoConDatos() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarArista(0, 1, 5.0);

        grafo.crearGrafo();

        assertFalse(grafo.existeVertice(0));
        assertFalse(grafo.existeVertice(1));
        assertFalse(grafo.existeArista(0, 1));
    }

    // -------------------------------------------------------------------------
    // agregarVertice
    // -------------------------------------------------------------------------

    @Test
    public void agregarVertice_verticeNuevo_existeEnGrafo() {
        grafo.agregarVertice(10);
        assertTrue(grafo.existeVertice(10));
    }

    @Test
    public void agregarVertice_variosVertices_todosExisten() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(50);
        grafo.agregarVertice(99);

        assertTrue(grafo.existeVertice(0));
        assertTrue(grafo.existeVertice(50));
        assertTrue(grafo.existeVertice(99));
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarVertice_indiceNegativo_lanzaExcepcion() {
        grafo.agregarVertice(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarVertice_indiceFueraDeRango_lanzaExcepcion() {
        grafo.agregarVertice(100);
    }

    // -------------------------------------------------------------------------
    // eliminarVertice
    // -------------------------------------------------------------------------

    @Test
    public void eliminarVertice_verticeExistente_noExisteMas() {
        grafo.agregarVertice(5);
        grafo.eliminarVertice(5);
        assertFalse(grafo.existeVertice(5));
    }

    @Test
    public void eliminarVertice_eliminaAristasAsociadas() {
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(1, 2, 10.0);
        grafo.agregarArista(1, 3, 20.0);

        grafo.eliminarVertice(1);

        assertFalse(grafo.existeArista(1, 2));
        assertFalse(grafo.existeArista(2, 1));
        assertFalse(grafo.existeArista(1, 3));
        assertFalse(grafo.existeArista(3, 1));
    }

    @Test
    public void eliminarVertice_verticeInexistente_noLanzaExcepcion() {
        // Eliminar un vértice que no fue agregado no debe lanzar excepción
        grafo.eliminarVertice(7);
        assertFalse(grafo.existeVertice(7));
    }

    // -------------------------------------------------------------------------
    // agregarArista
    // -------------------------------------------------------------------------

    @Test
    public void agregarArista_aristaValida_existeEnAmbosSentidos() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarArista(0, 1, 3.5);

        assertTrue(grafo.existeArista(0, 1));
        assertTrue(grafo.existeArista(1, 0)); // no dirigido
    }

    @Test
    public void agregarArista_pesoCorrectoEnAmbosSentidos() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarArista(0, 1, 7.25);

        assertEquals(7.25, grafo.getPeso(0, 1), 0.001);
        assertEquals(7.25, grafo.getPeso(1, 0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarArista_verticeOrigenInexistente_lanzaExcepcion() {
        grafo.agregarVertice(1);
        grafo.agregarArista(0, 1, 1.0); // 0 no fue agregado
    }

    @Test(expected = IllegalArgumentException.class)
    public void agregarArista_verticeDestinoInexistente_lanzaExcepcion() {
        grafo.agregarVertice(0);
        grafo.agregarArista(0, 1, 1.0); // 1 no fue agregado
    }

    @Test
    public void agregarArista_actualizaPeso_siYaExistia() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarArista(0, 1, 5.0);
        grafo.agregarArista(0, 1, 99.0); // sobreescribe

        assertEquals(99.0, grafo.getPeso(0, 1), 0.001);
    }

    // -------------------------------------------------------------------------
    // eliminarArista
    // -------------------------------------------------------------------------

    @Test
    public void eliminarArista_aristaExistente_noExisteMas() {
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(2, 3, 4.0);

        grafo.eliminarArista(2, 3);

        assertFalse(grafo.existeArista(2, 3));
        assertFalse(grafo.existeArista(3, 2));
    }

    @Test
    public void eliminarArista_aristaInexistente_noLanzaExcepcion() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        // No se agregó arista, no debe lanzar excepción
        grafo.eliminarArista(0, 1);
        assertFalse(grafo.existeArista(0, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getPeso_aristaInexistente_lanzaExcepcion() {
        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.getPeso(0, 1); // no hay arista
    }
}
