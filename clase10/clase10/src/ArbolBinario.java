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
            this.raiz= new Nodo<>(elemento);
        } else {
            if (raiz.izq == null && raiz.der == null) {
                int aux = random.nextInt(2);
                if (aux == 0)
                    raiz.izq = new Nodo<>(elemento);
                else {
                    raiz.der = new Nodo<>(elemento);
                }
            }
            if (raiz.izq == null) {
                raiz.izq = new Nodo<>(elemento);
            } else if (raiz.der == null) raiz.der = new Nodo<>(elemento);
            

        }

    }

    @Override
    public void imprimir() {
        if(!this.estaVacio()) {
            System.out.println("Raiz "+ this.raiz);
            if(raiz.izq != null) System.out.println("izq " + raiz.izq);
            if(raiz.der != null) System.out.println("der " + raiz.der);
        }
    }

    @Override
    public boolean estaVacio() {
        return this.raiz==null;
    }

    @Override
    public void elimar(T elemento) {

    }


}
