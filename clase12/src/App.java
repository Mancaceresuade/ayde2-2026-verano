import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {

        // Set<Integer> conjunto = new TreeSet<>();

        ArbolBinario<Integer> arbolBinario = new ArbolBinario<>();
        // System.out.println(arbolBinario.estaVacio());
        arbolBinario.estaVacio();
        arbolBinario.agregarElemento(12);
        arbolBinario.agregarElemento(10);
        arbolBinario.agregarElemento(4);
        arbolBinario.agregarElemento(20);
        arbolBinario.agregarElemento(30);
        arbolBinario.agregarElemento(5);
        arbolBinario.imprimir();
        System.out.println("Maxima hoja " + arbolBinario.maximaHojas());
        // System.out.println(App.factorialRec(5)); // 5*4*3*2*1 = 120
        // int[] numeros = {4,5,6,7}; // 22
        //System.out.println("Suma recursiva "+ sumaRec2(numeros,numeros.length-1));
    }

    private static int sumaRec(int[] numeros, int i) {
        if(numeros.length == i) return 0;
        return numeros[i] + sumaRec(numeros,i+1);
    }

    private static int sumaRec2(int[] numeros, int i) {
        if(i == 0) return numeros[i];
        return numeros[i] + sumaRec2(numeros,i-1);
    }

    public static int factorialRec(int n) {
        // caso base
        if(n==0) return 1;
        // llamado recursivo
        int aux = n * factorialRec(n-1);
        return aux;
    }  

    public static int factorialIter(int n) {
        int ret = n;
        for (int i = n - 1; i > 1; i--) {
            ret = ret * i;
        }
        return ret;
    }
}
