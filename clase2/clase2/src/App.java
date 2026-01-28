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
    }
    public static boolean algunaColumnaTodosMultiploDeTres(int[][] aux2) {
        boolean rta = false;
        for (int col = 0; col < aux2.length; col++) {
            rta = rta || columnaTodosMultiplosDeTres(aux2,col);
        }
        return rta;
    }
    
    private static boolean columnaTodosMultiplosDeTres(int[][] aux2, int col) {
        boolean rta = true;
        for (int i = 0; i < aux2.length; i++) {
            rta = rta && (aux2[i][col]%3)==0;
        }
        return rta;
    }

    private static boolean algunaFilaTodosMultiplosDeDos(int[][] aux2) {
        boolean rta = false; // 1
        int j=0;
        while (j<aux2.length) {
            
        }
        for (int i = 0; i < aux2.length; i++) { // 1 + 2n + 1 
            rta = rta || todosPares(aux2[i]); // 2 n  + n ( f(n) ) = 2n + n( 8n+5) = 2n + 8n**2 + 5
        }
        return rta; // 1
    } // t(n) = 9n + 8n**2 + 3
    // t(n) <= c g(n)
    // 9n + 8n**2 + 3 <= 9n**2 
    // 9n/n**2 + 8n**2 / n**2 + 3 / n**2 <=  9n**2  / n**2
    // 9/n + 8 + 3 / n**2 <=  9
    // f(n) pertence a O(n**2) para c= 9  y desde n0 > 10

    private static boolean todosPares(int[] arr) {
        boolean rta = true;
        for(int i = 0; i < arr.length; i++) {
            rta = rta && (arr[i]%2)==0;
        }
        return rta;
    } // f(n) = 8n + 5 

    private static boolean hayPares(int[] numeros) {
        boolean rta = false;  // 1
        for (int i = 0; i < numeros.length; i++) { // 1 +  2 n + n
            // rta = rta || ((numeros[i]%2)==0); // 5 n
            if ((numeros[i]%2)==0) {
                rta = true;   // ¿ peor caso ? todos pares
            }
        }
        return rta; // 1
    } // t(n) = 8n + 3
        // t(n) <= c g(n)
        // 8n + 3 <= 


    private static void calcular() {
        int i = 0; // 1
        i = i + 1; // 2
        i = i + 1; // 2
    } // t(n) = 5
}
