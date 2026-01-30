import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args)  {
        ConjuntoTDA conjunto = new ConjuntoDinamico();
        conjunto.InicializarConjunto();
        System.out.println(conjunto.ConjuntoVacio());
        conjunto.Agregar(20);
        conjunto.Agregar(30);
        conjunto.Agregar(20);
        conjunto.imprimir();


        /*
        Set<String> conjuntoHash = new HashSet<>();
        Set<String> conjuntoTree = new TreeSet<>();
        conjuntoTree.add("algo");
        conjuntoTree.add("nuevo");
        System.out.println(conjuntoHash);
         */
        

    }

    public static void parOrdenado() {
        try {
            
            ParOrdenado<String,String> equipos = new ParOrdenado<String,String>("River", null);
            System.out.println(equipos);
            ParOrdenado<String,Integer> golesequipo1 = new ParOrdenado<String,Integer>("River", 2);
            System.out.println(golesequipo1);
            ParOrdenado<Integer,Integer> coordenada1;
            ParOrdenado<Integer,Integer> coordenada2;
            coordenada1 = new ParOrdenado<Integer,Integer>(3, null);
            coordenada2 = new ParOrdenado<Integer,Integer>(4, 3);
            System.out.println(coordenada1);
            System.out.println(coordenada2);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
        System.out.println("El sistema no se tildó");

    }
}
