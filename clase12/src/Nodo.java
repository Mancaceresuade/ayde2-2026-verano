public class Nodo<T extends Comparable<T>> {
    T elemento;
    Nodo<T> izq;
    Nodo<T> der;
    int altura;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.altura = 1;
    }
    @Override
    public String toString() {
        return this.elemento.toString();
    }
}
