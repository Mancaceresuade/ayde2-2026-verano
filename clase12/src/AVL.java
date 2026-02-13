public class AVL<T extends Comparable<T>> implements iArbolBinarioTDA<T>{

    ArbolBinario<T> arbolBinario = new ArbolBinario<T>();

    @Override
    public void crearArbol() {
        this.arbolBinario.crearArbol();
    }

    @Override
    public void agregarElemento(T elemento) {
        arbolBinario.raiz = agregar(arbolBinario.raiz, elemento);
    }

    private Nodo<T> agregar(Nodo<T> nodo, T elemento) {
        if (nodo == null) {
            return new Nodo<T>(elemento);
        }
        if (elemento.compareTo(nodo.elemento) < 0) {
            nodo.izq = agregar(nodo.izq, elemento);
        } else if (elemento.compareTo(nodo.elemento) > 0) {
            nodo.der = agregar(nodo.der, elemento);
        } else {
            // elemento ya existe -> no insertar duplicados
            return nodo;
        }

        // actualizar altura
        actualizarAltura(nodo);

        int balance = getBalance(nodo);

        // Left Left
        if (balance > 1 && elemento.compareTo(nodo.izq.elemento) < 0)
            return rotarDerecha(nodo);

        // Right Right
        if (balance < -1 && elemento.compareTo(nodo.der.elemento) > 0)
            return rotarIzquierda(nodo);

        // Left Right
        if (balance > 1 && elemento.compareTo(nodo.izq.elemento) > 0) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }

        // Right Left
        if (balance < -1 && elemento.compareTo(nodo.der.elemento) < 0) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private int altura(Nodo<T> nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    private void actualizarAltura(Nodo<T> nodo) {
        if (nodo != null) {
            nodo.altura = 1 + Math.max(altura(nodo.izq), altura(nodo.der));
        }
    }

    private int getBalance(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return altura(nodo.izq) - altura(nodo.der);
    }

    private Nodo<T> rotarDerecha(Nodo<T> y) {
        Nodo<T> x = y.izq;
        Nodo<T> T2 = x.der;

        x.der = y;
        y.izq = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    private Nodo<T> rotarIzquierda(Nodo<T> x) {
        Nodo<T> y = x.der;
        Nodo<T> T2 = y.izq;

        y.izq = x;
        x.der = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    @Override
    public void imprimir() {
        arbolBinario.imprimir();
    }

    @Override
    public boolean estaVacio() {
        return arbolBinario.estaVacio();
    }

    @Override
    public void elimar(T elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'elimar'");
    }

    @Override
    public T maximaHojas() {
        return arbolBinario.maximaHojas();
    }

    


}
