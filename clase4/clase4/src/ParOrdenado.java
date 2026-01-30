// Implementacion de Par ordenado
public class ParOrdenado<T,V> {
    T dato1;
    V dato2;
    public ParOrdenado(T dato1, V dato2) {
        // Implementa invariante de representacion
        if(dato1 == null || dato2 == null) throw new RuntimeException("Dato1 o Dato2 obligatorio");
        this.dato1 = dato1;
        this.dato2 = dato2;
    }
    @Override
    public String toString() {
        return "dato 1" + dato1 + " dato 2 " + dato2;
    }
}
