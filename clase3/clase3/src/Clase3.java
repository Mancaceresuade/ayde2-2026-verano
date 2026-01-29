public class Clase3 {
    public static void main(String[] args) {
        ParOrdenado<Integer,Integer> coordena1 = new ParOrdenado<Integer,Integer>(10, 15);
        ParOrdenado<Integer,Integer> coordena2 = new ParOrdenado<Integer,Integer>(15, 10);
        ParOrdenado<Integer,Integer> coordena3 = new ParOrdenado<Integer,Integer>(1, 2);
        coordena1.imprimir();
        coordena2.imprimir();
        coordena3.imprimir();
        ParOrdenado<String,String> datos = new ParOrdenado<String,String>("Tel", "23523");
        datos.imprimir();
    }
}
