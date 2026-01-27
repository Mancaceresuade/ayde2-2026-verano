import java.util.Scanner;
// cambio de nuevo
public class App {
    public static int sumar(int num1, int num2) {
        return num1+num2;
    }

    public static void imprimirCiclo() {
        int i=0;
        do {
            System.out.println(i);
            i++;
            if(i > 5) continue;
        } while (i < 10);
        /*
        int i=0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
         */    
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
         */    
    }

    public static void recorrerMatriz() {
        int matriz[][] = {{3,4,1,2,6},{3,4,1,2,5}};
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz.length; c++) {
                System.out.println(matriz[f][c]);
            }
        }
    }

    public static void recorrerVector() {
        int vector[] = {3,4,1,2,6};
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }


    public static void main(String[] args) throws Exception {
        App.recorrerVector();
        //App.imprimirCiclo();
        //Proceso.miFuncion();
        //App.calcular();
        //System.out.println("Suma de 5+4 "+ App.sumar(5, 4));
        //unaPractica();
    }


    public static void calcular() {
        int numero = 10;
        if(numero > 5) {
            System.out.println("Mayor a 5");
        } else {
            System.out.println("Menor a 5");
        }
    }

    private static void unaPractica() {
        /*
        String saludo = "Hola mundo";
        // saludo = 10;
        System.out.println(saludo);
        int numero = 10;
        System.out.println(numero);
         */
    }

    
}
