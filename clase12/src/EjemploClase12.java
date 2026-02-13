import java.util.List;

public class EjemploClase12 {
    public static void main(String[] args) {
        AVL<Producto> abb = new AVL<>();

        Producto prod1 = new Producto();
        prod1.id = 1;
        prod1.nombre = "Producto 1";

        Producto prod2 = new Producto();
        prod2.id = 2;
        prod2.nombre = "Producto 2";

        Producto prod3 = new Producto();
        prod3.id = 3;
        prod3.nombre = "Producto 3";

        Producto prod4 = new Producto();
        prod4.id = 4;
        prod4.nombre = "Producto 4";

        Producto prod5 = new Producto();
        prod5.id = 5;
        prod5.nombre = "Producto 5";

        // System.out.println(prod1.compareTo(prod2));
        abb.agregarElemento(prod3);
        abb.agregarElemento(prod1);
        abb.agregarElemento(prod2);
        abb.agregarElemento(prod4);
        abb.agregarElemento(prod5);
        abb.imprimir();

        // complejidad O(n**2)
        for (int i = 0; i < abb.arbolBinario.altura(); i++) {
            System.out.println("Nivel " + i);
            List<Producto> nodos = abb.arbolBinario.nodosEnNivel(i);
            nodos.forEach(n -> System.out.println(n));
        }

    }
}
