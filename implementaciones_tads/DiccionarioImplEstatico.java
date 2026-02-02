package clase5;

public class DiccionarioImplEstatico<T, V> {

    // Tamaño máximo del diccionario
    private static final int TAMANIO_MAXIMO = 100;

    // Array de tuplas para claves y valores
    private Tupla<T, V>[] elementos;

    // Cantidad actual de elementos en el diccionario
    private int cantidad;

    // Constructor
    @SuppressWarnings("unchecked")
    public DiccionarioImplEstatico() {
        elementos = new Tupla[TAMANIO_MAXIMO];
        cantidad = 0;
    }

    // Agregar una clave-valor al diccionario
    public boolean agregar(T clave, V valor) {
        if (cantidad >= TAMANIO_MAXIMO || buscar(clave) != null) {
            return false; // Diccionario lleno o clave ya existente
        }
        elementos[cantidad++] = new Tupla<>(clave, valor);
        return true;
    }

    // Eliminar una clave del diccionario
    public boolean eliminar(T clave) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].getClave().equals(clave)) {
                // Mover el último elemento al lugar del eliminado
                elementos[i] = elementos[cantidad - 1];
                elementos[cantidad - 1] = null;
                cantidad--;
                return true;
            }
        }
        return false; // Clave no encontrada
    }

    // Buscar el valor asociado a una clave
    public V buscar(T clave) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].getClave().equals(clave)) {
                return elementos[i].getValor();
            }
        }
        return null; // Clave no encontrada
    }

    // Verificar si el diccionario está vacío
    public boolean estaVacio() {
        return cantidad == 0;
    }

    // Obtener la cantidad de elementos en el diccionario
    public int obtenerCantidad() {
        return cantidad;
    }

    // Clase interna para representar una tupla
    private static class Tupla<T, V> {
        private final T clave;
        private final V valor;

        public Tupla(T clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        public T getClave() {
            return clave;
        }

        public V getValor() {
            return valor;
        }
    }
}