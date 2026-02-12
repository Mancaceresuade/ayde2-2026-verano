public class EjemploClase12 {
    public static void main(String[] args) {
        ABB<Producto> abb = new ABB<>();

        Producto prod1 = new Producto();
        prod1.id = 1;
        prod1.nombre = "Producto 1";

        Producto prod2 = new Producto();
        prod2.id = 2;
        prod2.nombre = "Producto 2";

        Producto prod3 = new Producto();
        prod3.id = 3;
        prod3.nombre = "Producto 3";

        // System.out.println(prod1.compareTo(prod2));
        abb.agregarElemento(prod3);
        abb.agregarElemento(prod1);
        abb.agregarElemento(prod2);
        abb.imprimir();
    }
}
