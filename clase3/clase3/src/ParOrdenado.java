// TAD ParOrdenado
// Datos numero1, numero2
// Operaciones : crear
// Invariante de Representacion
// dos elementos, no nulo , ordenado, inmutable
// Implementacion: 
public class ParOrdenado<A,B> {
    A numero1;
    B numero2;
    public ParOrdenado(A numero1, B numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    public void imprimir() {
        System.out.println("dato 1 " + this.numero1 + " dato 2 "+ this.numero2);
    }
}
