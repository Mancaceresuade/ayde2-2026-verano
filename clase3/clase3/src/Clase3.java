public class Clase3 {
    public static void main(String[] args) {

        Conjunto jugadores = new Conjunto(11);
        jugadores.agregar("Beltran");
        jugadores.agregar("Montiel");
        jugadores.agregar("Rivero");
        jugadores.agregar("Moreno");
        jugadores.agregar("Vera");
        jugadores.agregar("Quintero");
        jugadores.agregar("Salas");
        jugadores.imprimir();


        /*
        ParOrdenado<String,String> partido = new ParOrdenado<String,String>("Millo", "Lobo");

        ParOrdenado<String,Integer> resultado = new ParOrdenado<String,Integer>("Millo", 2);

        Tupla3<String,String,String> expulsados = new Tupla3<String,String,String>("Viña","Panaro","");
        
        System.out.println(expulsados);

        ParOrdenado<Integer,Integer> coordena1 = new ParOrdenado<Integer,Integer>(10, 15);
        ParOrdenado<Integer,Integer> coordena2 = new ParOrdenado<Integer,Integer>(15, 10);
        ParOrdenado<Integer,Integer> coordena3 = new ParOrdenado<Integer,Integer>(1, 2);
        coordena1.imprimir();
        coordena2.imprimir();
        coordena3.imprimir();
        ParOrdenado<String,String> datos = new ParOrdenado<String,String>("Tel", "23523");
        datos.imprimir();
        Tupla3<String,String,String> tupla3 = 
            new Tupla3<String,String,String>("coordena2", "coordena3", "datos");
        System.out.println(tupla3);
         */
    }
}
