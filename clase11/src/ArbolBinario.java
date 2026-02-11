import java.util.Random;

public class ArbolBinario<T> implements  iArbolBinarioTDA<T>{
    Nodo<T> raiz;
    static Random random = new Random();
    @Override
    public void crearArbol() {
        this.raiz = null;
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


}
