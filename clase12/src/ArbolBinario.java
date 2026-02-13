import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArbolBinario<T extends Comparable<T>> implements  iArbolBinarioTDA<T>{
    Nodo<T> raiz;
    static Random random = new Random();
    @Override
    public void crearArbol() {
        this.raiz = null;
    }

    public T maximaHojas() {
        //recorrer el arbol y devolver la maxima hoja
        return maximaHojas(raiz);    
    }

    private T maximaHojas(Nodo<T> nodo) {
        if(nodo == null) return null;
        if(nodo.izq == null && nodo.der == null) return nodo.elemento;
        T maxIzq = maximaHojas(nodo.izq);
        T maxDer = maximaHojas(nodo.der);
        if(maxIzq == null) return maxDer;
        if(maxDer == null) return maxIzq;
        return maxIzq.compareTo(maxDer) > 0 ? maxIzq : maxDer;
    }

    public int longitudDeLaRamaMasCorta() {
        return longitudDeLaRamaMasCorta(raiz);
    }

    private int longitudDeLaRamaMasCorta(Nodo<T> nodo) {
        if(nodo == null) return 0;
        return 1 + Math.min(longitudDeLaRamaMasCorta(nodo.izq), longitudDeLaRamaMasCorta(nodo.der));
    }

    // Cambiar el nodo actual con el mayor valor de sus hijos, siempre que ambos
    // no sean nulos. Si son nulos o alguno de los dos es nulo no hace nada.

    public void cambiarNodoActualConElMayorValorDeSusHijos() {
        cambiarNodoActualConElMayorValorDeSusHijos(raiz);
    }

    private void cambiarNodoActualConElMayorValorDeSusHijos(Nodo<T> nodo) {
        if(nodo == null) return;
        if(nodo.izq == null && nodo.der == null) return;
        if(nodo.izq == null) {
            nodo.elemento = nodo.der.elemento;
            nodo.der = null;
        } else if (nodo.der == null) {
            nodo.elemento = nodo.izq.elemento;
            nodo.izq = null;
        } else {
            T maxIzq = maximaHojas(nodo.izq);
            T maxDer = maximaHojas(nodo.der);
            if(maxIzq.compareTo(maxDer) > 0) {
                nodo.elemento = maxIzq;
                nodo.izq = null;
            } else {
                nodo.elemento = maxDer;
                nodo.der = null;
            }
        }
    }




    @Override
    public void agregarElemento(T elemento) {
        if(this.estaVacio()) {
            this.raiz = new Nodo<>(elemento);
        } else {
            agregarElemento(raiz, elemento);
        }
    }

    private void agregarElemento(Nodo<T> nodo, T elemento) {
        if(nodo.izq == null) {
            nodo.izq = new Nodo<>(elemento);
        } else if (nodo.der == null) {
            nodo.der = new Nodo<>(elemento);
        } else {
            if(random.nextBoolean()) {
                agregarElemento(nodo.izq, elemento);
            } else {
                agregarElemento(nodo.der, elemento);
            }
        }
    }

    @Override
    public void imprimir() {
        if(this.estaVacio()) return;
        imprimir(raiz);
        /*
        if(!this.estaVacio()) {
            System.out.println("Raiz "+ this.raiz);
            if(raiz.izq != null) System.out.println("izq " + raiz.izq);
            if(raiz.der != null) System.out.println("der " + raiz.der);
            if(raiz.izq != null) System.out.println("izq " + raiz.izq);
            if(raiz.der != null) System.out.println("der " + raiz.der);
            if(raiz.izq != null) System.out.println("izq " + raiz.izq);
            if(raiz.der != null) System.out.println("der " + raiz.der);
        }
             */
    }

    private void imprimir(Nodo<T> nodo) {
        if(nodo == null) return;
        imprimir(nodo.izq);
        System.out.println(nodo.elemento.toString());
        imprimir(nodo.der);
    }

    @Override
    public boolean estaVacio() {
        return this.raiz==null;
    }

    @Override
    public void elimar(T elemento) {

    }

    public List<T> nodosEnNivel(int nivel) {
        ArrayList<T> lista = new java.util.ArrayList<>();
        nodosEnNivel(raiz, nivel, 0, lista);
        return lista;
    }

    private void nodosEnNivel(Nodo<T> nodo, int nivel, int nivelActual, ArrayList<T> lista) {
        if(nodo == null) return;
        if(nivelActual == nivel) {
            lista.add(nodo.elemento);
        }
        nodosEnNivel(nodo.izq, nivel, nivelActual + 1,lista);
        nodosEnNivel(nodo.der, nivel, nivelActual + 1,lista);

    }





    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }
}
