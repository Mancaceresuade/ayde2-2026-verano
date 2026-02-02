package clase5;

public class DequeImplEstatica<T> {
    private static final int CAPACIDAD_MAXIMA = 100;
    private T[] elementos;
    private int frente;
    private int fondo;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public DequeImplEstatica() {
        elementos = (T[]) new Object[CAPACIDAD_MAXIMA];
        frente = 0;
        fondo = -1;
        tamaño = 0;
    }

    public boolean estaVacio() {
        return tamaño == 0;
    }

    public boolean estaLleno() {
        return tamaño == CAPACIDAD_MAXIMA;
    }

    public void insertarFrente(T elemento) {
        if (estaLleno()) {
            throw new IllegalStateException("El deque está lleno");
        }
        frente = (frente - 1 + CAPACIDAD_MAXIMA) % CAPACIDAD_MAXIMA;
        elementos[frente] = elemento;
        tamaño++;
    }

    public void insertarFondo(T elemento) {
        if (estaLleno()) {
            throw new IllegalStateException("El deque está lleno");
        }
        fondo = (fondo + 1) % CAPACIDAD_MAXIMA;
        elementos[fondo] = elemento;
        tamaño++;
    }

    public T eliminarFrente() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        T elemento = elementos[frente];
        frente = (frente + 1) % CAPACIDAD_MAXIMA;
        tamaño--;
        return elemento;
    }

    public T eliminarFondo() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        T elemento = elementos[fondo];
        fondo = (fondo - 1 + CAPACIDAD_MAXIMA) % CAPACIDAD_MAXIMA;
        tamaño--;
        return elemento;
    }

    public T obtenerFrente() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos[frente];
    }

    public T obtenerFondo() {
        if (estaVacio()) {
            throw new IllegalStateException("El deque está vacío");
        }
        return elementos[fondo];
    }

    public int obtenerTamaño() {
        return tamaño;
    }
}