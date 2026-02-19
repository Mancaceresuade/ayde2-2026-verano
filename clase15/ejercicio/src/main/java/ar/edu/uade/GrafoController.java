package ar.edu.uade;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST Controller para el Grafo Ponderado.
 * Base URL: /api/grafo
 */
@RestController
@RequestMapping("/api/grafo")
@Tag(name = "Grafo Ponderado", description = "Operaciones sobre el grafo ponderado no dirigido")
public class GrafoController {

    private final GrafoPonderadoEstatico grafo;

    @Autowired
    public GrafoController(GrafoPonderadoEstatico grafo) {
        this.grafo = grafo;
    }

    // -------------------------------------------------------------------------
    // POST /api/grafo/crear
    // -------------------------------------------------------------------------
    @Operation(summary = "Crear grafo", description = "Crea un grafo vacío (reinicia el estado actual).")
    @ApiResponse(responseCode = "200", description = "Grafo creado exitosamente")
    @PostMapping("/crear")
    public ResponseEntity<String> crearGrafo() {
        grafo.crearGrafo();
        return ResponseEntity.ok("Grafo creado exitosamente.");
    }

    // -------------------------------------------------------------------------
    // POST /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------
    @Operation(summary = "Agregar vértice", description = "Agrega el vértice v al grafo (índice entre 0 y 99).")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vértice agregado"),
            @ApiResponse(responseCode = "400", description = "Índice fuera de rango")
    })
    @PostMapping("/vertice/{v}")
    public ResponseEntity<String> agregarVertice(
            @Parameter(description = "Índice del vértice (0–99)") @PathVariable int v) {
        try {
            grafo.agregarVertice(v);
            return ResponseEntity.ok("Vértice " + v + " agregado.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // DELETE /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------
    @Operation(summary = "Eliminar vértice", description = "Elimina el vértice v y todas sus aristas.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vértice eliminado"),
            @ApiResponse(responseCode = "400", description = "Índice fuera de rango")
    })
    @DeleteMapping("/vertice/{v}")
    public ResponseEntity<String> eliminarVertice(
            @Parameter(description = "Índice del vértice (0–99)") @PathVariable int v) {
        try {
            grafo.eliminarVertice(v);
            return ResponseEntity.ok("Vértice " + v + " eliminado.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // GET /api/grafo/vertice/{v}
    // -------------------------------------------------------------------------
    @Operation(summary = "Consultar vértice", description = "Indica si el vértice v existe en el grafo.")
    @ApiResponse(responseCode = "200", description = "Resultado de la consulta")
    @GetMapping("/vertice/{v}")
    public ResponseEntity<Map<String, Object>> existeVertice(
            @Parameter(description = "Índice del vértice (0–99)") @PathVariable int v) {
        boolean existe = grafo.existeVertice(v);
        return ResponseEntity.ok(Map.of("vertice", v, "existe", existe));
    }

    // -------------------------------------------------------------------------
    // POST /api/grafo/arista
    // -------------------------------------------------------------------------
    @Operation(summary = "Agregar arista", description = "Agrega una arista ponderada entre los vértices v y w. Ambos deben existir previamente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arista agregada"),
            @ApiResponse(responseCode = "400", description = "Vértice inexistente o índice fuera de rango")
    })
    @PostMapping("/arista")
    public ResponseEntity<String> agregarArista(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Vértices y peso de la arista", required = true) @RequestBody AristaRequest req) {
        try {
            grafo.agregarArista(req.v(), req.w(), req.peso());
            return ResponseEntity.ok(
                    "Arista (" + req.v() + " - " + req.w() + ") con peso " + req.peso() + " agregada.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // DELETE /api/grafo/arista/{v}/{w}
    // -------------------------------------------------------------------------
    @Operation(summary = "Eliminar arista", description = "Elimina la arista entre los vértices v y w.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arista eliminada"),
            @ApiResponse(responseCode = "400", description = "Índice fuera de rango")
    })
    @DeleteMapping("/arista/{v}/{w}")
    public ResponseEntity<String> eliminarArista(
            @Parameter(description = "Vértice origen (0–99)") @PathVariable int v,
            @Parameter(description = "Vértice destino (0–99)") @PathVariable int w) {
        try {
            grafo.eliminarArista(v, w);
            return ResponseEntity.ok("Arista (" + v + " - " + w + ") eliminada.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // GET /api/grafo/arista/{v}/{w}
    // -------------------------------------------------------------------------
    @Operation(summary = "Consultar arista", description = "Indica si existe arista entre v y w, y devuelve su peso si existe.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resultado de la consulta"),
            @ApiResponse(responseCode = "400", description = "Índice fuera de rango")
    })
    @GetMapping("/arista/{v}/{w}")
    public ResponseEntity<Map<String, Object>> consultarArista(
            @Parameter(description = "Vértice origen (0–99)") @PathVariable int v,
            @Parameter(description = "Vértice destino (0–99)") @PathVariable int w) {
        try {
            boolean existe = grafo.existeArista(v, w);
            if (existe) {
                double peso = grafo.getPeso(v, w);
                return ResponseEntity.ok(Map.of("v", v, "w", w, "existe", true, "peso", peso));
            } else {
                return ResponseEntity.ok(Map.of("v", v, "w", w, "existe", false));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
