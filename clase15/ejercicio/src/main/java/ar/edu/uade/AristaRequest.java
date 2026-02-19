package ar.edu.uade;

/**
 * DTO para la creación de una arista ponderada.
 *
 * @param v    vértice origen
 * @param w    vértice destino
 * @param peso peso de la arista
 */
public record AristaRequest(int v, int w, double peso) {
}
