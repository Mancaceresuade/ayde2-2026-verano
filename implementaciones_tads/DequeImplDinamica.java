package clase5;

public class DequeImplDinamica<T> {
    private Nodo<T> frente;
    private Nodo<T> fondo;

    // Clase interna para representar un nodo
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    // Constructor
    public DequeImplDinamica() {
        this.frente = null;
        this.fondo = null;
    }

    // Verifica si el deque está vacío
    public boolean estaVacio() {
        return frente == null;
    }

    // Agregar un elemento al frente
    public void agregarFrente(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (estaVacio()) {
            frente = fondo = nuevo;
        } else {
            nuevo.siguiente = frente;
            frente.anterior = nuevo;
            frente = nuevo;
        }
    }

    // Agregar un elemento al fondo
    public void agregarFondo(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (estaVacio()) {
            frente = fondo = nuevo;
        } else {
            nuevo.anterior = fondo;
            fondo.siguiente = nuevo;
            fondo = nuevo;
        }
    }

    // Eliminar un elemento del frente
    public T eliminarFrente() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fondo = null;
        } else {
            frente.anterior = null;
        }
        return dato;
    }

    // Eliminar un elemento del fondo
    public T eliminarFondo() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        T dato = fondo.dato;
        fondo = fondo.anterior;
        if (fondo == null) {
            frente = null;
        } else {
            fondo.siguiente = null;
        }
        return dato;
    }

    // Obtener el elemento del frente sin eliminarlo
    public T obtenerFrente() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return frente.dato;
    }

    // Obtener el elemento del fondo sin eliminarlo
    public T obtenerFondo() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return fondo.dato;
    }
}