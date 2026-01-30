// TAD Tupla
// 
public final class Tupla3<T, U, V> {
    private final T primero;
    private final U segundo;
    private final V tercero;
    public Tupla3(T primero, U segundo, V tercero) {
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }
    public T getPrimero() { return primero; }
    public U getSegundo() { return segundo; }
    public V getTercero() { return tercero; }
    public String toString() {
        return "(" + primero + ", " + segundo + ", " + tercero + ")";
    }
}