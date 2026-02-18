package edu.uade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que implementa iGrafoController.
 * Expone las operaciones de iGrafoTDA vía API REST.
 */
@RestController
@RequestMapping("/api/grafo")
public class GrafoRestController implements iGrafoController {

    private final iGrafoTDA<String> grafo;

    public GrafoRestController() {
        grafo = new GrafoDinamico<>();
        grafo.crearGrafo();
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> crearGrafo() {
        grafo.crearGrafo();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @PostMapping("/vertices/{v}")
    public ResponseEntity<Void> agregarVertice(@PathVariable String v) {
        grafo.agregarVertice(v);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping("/vertices/{v}")
    public ResponseEntity<Void> eliminarVertice(@PathVariable String v) {
        grafo.eliminarVertice(v);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PostMapping("/aristas")
    public ResponseEntity<Void> agregarArista(@RequestParam String v, @RequestParam String w) {
        grafo.agregarArista(v, w);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping("/aristas")
    public ResponseEntity<Void> eliminarArista(@RequestParam String v, @RequestParam String w) {
        grafo.eliminarArista(v, w);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/vertices/{v}/existe")
    public ResponseEntity<Boolean> existeVertice(@PathVariable String v) {
        return ResponseEntity.ok(grafo.existeVertice(v));
    }

    @Override
    @GetMapping("/aristas/existe")
    public ResponseEntity<Boolean> existeArista(@RequestParam String v, @RequestParam String w) {
        return ResponseEntity.ok(grafo.existeArista(v, w));
    }

    @Override
    @GetMapping("/vertices/{v}/vecinos")
    public ResponseEntity<List<String>> obtenerVecinos(@PathVariable String v) {
        return ResponseEntity.ok(grafo.obtenerVecinos(v));
    }

    @Override
    @GetMapping("/vertices/{v}/grado")
    public ResponseEntity<Integer> obtenerGrado(@PathVariable String v) {
        return ResponseEntity.ok(grafo.obtenerGrado(v));
    }
}
