// TAD Nodo
// Datos: elemento, siguiente nodo
// Operaciones: crear, conectar, 
// IREP: elemento no nulo
public class Nodo {
    int elemento;
    Nodo siguiente;
    public Nodo(int elemento) {
        this.elemento = elemento;
        this.siguiente = null; 
    }
    public void conectar(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    @Override
    public String toString() {
        return "elemento "+this.elemento;
    }
}
