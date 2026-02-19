package ar.edu.uade;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GrafoController.class)
class GrafoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GrafoPonderadoEstatico grafo;

    @Autowired
    private ObjectMapper objectMapper;

    // -------------------------------------------------------------------------
    // POST /api/grafo/crear
    // -------------------------------------------------------------------------

    @Test
    void crearGrafo_retorna200() throws Exception {
        mockMvc.perform(post("/api/grafo/crear"))
                .andExpect(status().isOk())
                .andExpect(content().string("Grafo creado exitosamente."));

        verify(grafo, times(1)).crearGrafo();
    }

    // -------------------------------------------------------------------------
    // POST /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------

    @Test
    void agregarVertice_valido_retorna200() throws Exception {
        mockMvc.perform(post("/api/grafo/vertice/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Vértice 5 agregado."));

        verify(grafo).agregarVertice(5);
    }

    @Test
    void agregarVertice_indiceInvalido_retorna400() throws Exception {
        doThrow(new IllegalArgumentException("Índice fuera de rango: -1"))
                .when(grafo).agregarVertice(-1);

        mockMvc.perform(post("/api/grafo/vertice/-1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Índice fuera de rango: -1"));
    }

    // -------------------------------------------------------------------------
    // DELETE /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------

    @Test
    void eliminarVertice_valido_retorna200() throws Exception {
        mockMvc.perform(delete("/api/grafo/vertice/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Vértice 3 eliminado."));

        verify(grafo).eliminarVertice(3);
    }

    @Test
    void eliminarVertice_indiceInvalido_retorna400() throws Exception {
        doThrow(new IllegalArgumentException("Índice fuera de rango: 100"))
                .when(grafo).eliminarVertice(100);

        mockMvc.perform(delete("/api/grafo/vertice/100"))
                .andExpect(status().isBadRequest());
    }

    // -------------------------------------------------------------------------
    // GET /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------

    @Test
    void existeVertice_verticePresente_retornaTrueEnJson() throws Exception {
        when(grafo.existeVertice(7)).thenReturn(true);

        mockMvc.perform(get("/api/grafo/vertice/7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vertice").value(7))
                .andExpect(jsonPath("$.existe").value(true));
    }

    @Test
    void existeVertice_verticeAusente_retornaFalseEnJson() throws Exception {
        when(grafo.existeVertice(99)).thenReturn(false);

        mockMvc.perform(get("/api/grafo/vertice/99"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.existe").value(false));
    }

    // -------------------------------------------------------------------------
    // POST /api/grafo/arista
    // -------------------------------------------------------------------------

    @Test
    void agregarArista_valida_retorna200() throws Exception {
        AristaRequest req = new AristaRequest(0, 1, 5.5);

        mockMvc.perform(post("/api/grafo/arista")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(content().string("Arista (0 - 1) con peso 5.5 agregada."));

        verify(grafo).agregarArista(0, 1, 5.5);
    }

    @Test
    void agregarArista_verticeInexistente_retorna400() throws Exception {
        AristaRequest req = new AristaRequest(0, 1, 3.0);
        doThrow(new IllegalArgumentException("Ambos vértices deben existir en el grafo."))
                .when(grafo).agregarArista(0, 1, 3.0);

        mockMvc.perform(post("/api/grafo/arista")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Ambos vértices deben existir en el grafo."));
    }

    // -------------------------------------------------------------------------
    // DELETE /api/grafo/arista/{v}/{w}
    // -------------------------------------------------------------------------

    @Test
    void eliminarArista_valida_retorna200() throws Exception {
        mockMvc.perform(delete("/api/grafo/arista/2/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("Arista (2 - 4) eliminada."));

        verify(grafo).eliminarArista(2, 4);
    }

    @Test
    void eliminarArista_indiceInvalido_retorna400() throws Exception {
        doThrow(new IllegalArgumentException("Índice fuera de rango: 200"))
                .when(grafo).eliminarArista(200, 1);

        mockMvc.perform(delete("/api/grafo/arista/200/1"))
                .andExpect(status().isBadRequest());
    }

    // -------------------------------------------------------------------------
    // GET /api/grafo/arista/{v}/{w}
    // -------------------------------------------------------------------------

    @Test
    void consultarArista_aristaExistente_retornaPeso() throws Exception {
        when(grafo.existeArista(1, 2)).thenReturn(true);
        when(grafo.getPeso(1, 2)).thenReturn(7.25);

        mockMvc.perform(get("/api/grafo/arista/1/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.existe").value(true))
                .andExpect(jsonPath("$.peso").value(7.25));
    }

    @Test
    void consultarArista_aristaInexistente_retornaFalse() throws Exception {
        when(grafo.existeArista(1, 3)).thenReturn(false);

        mockMvc.perform(get("/api/grafo/arista/1/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.existe").value(false))
                .andExpect(jsonPath("$.peso").doesNotExist());
    }
}
