public class App {
    // monitoreo climatico
    // 1+3+3n+n*(3+3n+n*(3+3n+n*(1+2)))+1
    // f(n) = 6n**3 + 6n**2 + 6n +5
    // f(n) <= c g(n)
    // 6n**3 + 6n**2 + 6n +5  <= 7 n**3   // termino dominante mas 1
    // 6n**3/n**3 + 6n**2/n**3 + 6n/n**3 +5/n**3  <= 7 n**3/n**3
    // 6 + 6/n + 6/n**2 +5/n**3  <= 7 
    // f(n) pertenece a O(n**3)  para c = 7 y desde n0  6

    public static void main(String[] args) throws Exception {
        int[][] mat = {{2,3,4,6},{1,2,3,9},{21,3,12,9},{4,3,2,1}};
        System.out.println("Una fila con todos multiplos de "+ 
            unaFilaConTodosMultiplosDe(mat,3) );
    }
    // Estos calculos solo son para matrices cuadradas donde fila == columna
    private static boolean unaFilaConTodosMultiplosDe(int[][] mat, int divisor) {
        boolean rta = false; // 1
        int aux = mat.length; // 1
        for (int j = 0; j < aux; j++) { // // 1 + n + 1 + n  
            rta = rta || filaConTodosMultiplosDe(mat[j],divisor); // 2 n + n * f(n)
            // 2 n + n * (5+7n) = 2n + 5n + 7n**2 
        }
        return rta; // 1
    } // f(n) = 5 + 9n + 7n**2
    // f(n) <= c g(n)
    // 5 + 9n + 7n**2 <= 8 n**2   // termino dominante mas 1
    // 5/n**2 + 9n / n**2 + 7 n**2 / n**2 <= 8 n**2 / n ** 2
    // 5/n**2 + 9 / n + 7 <= 8 
    // ¿ A partir de que valor n0 se cumple ?
    // hasta 9 no cumple, a partir de 10 cumple
    // f(n) pertenece a O(n**2)  para c = 8 y desde n0 > 10

    private static boolean filaConTodosMultiplosDe(int[] fila, int divisor) {
        boolean rta = true; // 1
        int aux = fila.length; // 1
        for (int j = 0; j < aux; j++) { // 1 + n + 1 + n
            rta = rta && ((fila[j]%divisor)==0); // 5n
        }
        return rta; // 1
    } // t(n) = 5 + 7n  //   pertenece O(n)
      // t(n) <= c g(n)
      // 5 + 7n <= 8n   eligo 8 para acotar     
      // 5/n + 7n/n <= 8n / n
      // 5/n + 7 <= 8  cuando cumple ?  a partir de n0 > 5  ( probamos de 1 a 4 y no cumple )
      // t(n) pertenece a O(n) para c = 8 desde n0 > 5
       
    
    
}
