public interface iArbolBinarioTDA<T> {
    void crearArbol();
    void agregarElemento(T elemento);
    void imprimir();
    boolean estaVacio();
    void elimar(T elemento);
}
