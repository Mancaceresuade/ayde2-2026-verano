public class App {
    public static void main(String[] args) throws Exception {
        int[] numeros = {5,7};
        System.out.println("hay pares " + hayPares(numeros));
        int[] numeros1 = {8,10,12};
        System.out.println("todos pares " + todosPares(numeros1));
        int[][] aux2 = {
                { 9, 12, 18 },
                { 14, 10, 30 },
                { 9, 6, 3 } };
        System.out.println("alguna fila todos multiplos de 2 " + algunaFilaTodosMultiplosDeDos(aux2));        

    private static boolean algunaFilaTodosMultiplosDeDos(int[][] aux2) {
        boolean rta = false;
        for (int i = 0; i < aux2.length; i++) {
            rta = rta || todosPares(aux2[i]);
        }
        return rta;
    }

    private static boolean todosPares(int[] arr) {
        boolean rta = true;
        for(int i = 0; i < arr.length; i++) {
            rta = rta && (arr[i]%2)==0;
        }
        return rta;
    }

    private static boolean hayPares(int[] numeros) {
        boolean rta = false;
        for (int i = 0; i < numeros.length; i++) {
            rta = rta || ((numeros[i]%2)==0);
        }
        return rta;
    }
}
