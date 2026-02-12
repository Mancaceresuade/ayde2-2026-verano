public class EjemploClase11 {
    public static void main(String[] args) {
        
        ABB<Integer> abb = new ABB<Integer>();
        abb.agregarElemento(1);
        abb.agregarElemento(2);
        abb.agregarElemento(3);
        abb.agregarElemento(40);
        abb.agregarElemento(5);
        abb.agregarElemento(6);
        abb.agregarElemento(7);
        abb.agregarElemento(8);
        abb.agregarElemento(9);
        abb.imprimir();
        System.out.println("Maximo " + abb.maximo());

    }
}
