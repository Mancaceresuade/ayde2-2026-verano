public class App {
    public static void main(String[] args) throws Exception {
        int[] numeros = {5,7};
        System.out.println("hay pares " + hayPares(numeros));
        int[] numeros1 = {8,10,12};
        System.out.println("todos pares " + todosPares(numeros1));
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
