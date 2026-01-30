// TAD conjunto 
// datos
// operaciones: crear, agregar, eliminar, listar
// irep: no se puede repetir, sin orden, no puede ser nulo
// implementacion en estructar dinamica
public class ConjuntoDinamico implements ConjuntoTDA{
    Nodo nodo;

    @Override
    public void InicializarConjunto() {
        this.nodo = null;
    }

    @Override
    public boolean ConjuntoVacio() {
        return this.nodo == null;
    }

    @Override
    public void Agregar(int x) {
        if(this.Pertenece(x)) throw new RuntimeException("ya pertenece al conjunto ");
            // O(n)
        Nodo nuevo = new Nodo(x);
        if(this.nodo == null) {
            this.nodo = nuevo;
        } else {
            Nodo actual = this.nodo;
            while(actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    } // complejidad ? O(n) + O(n)  =>  O(n)  

    @Override
    public int Elegir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Elegir'");
    }

    @Override
    public void Sacar(int x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Sacar'");
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo aux = this.nodo;
        while((aux != null) && (aux.elemento != x)){
            aux = aux.siguiente;
        }
        return (aux != null);
    } // complejida O(n) porque el peor caso , el ultimo es el repetido

    @Override
    public void imprimir() {
        Nodo actual = this.nodo;
        while(actual != null) {
            System.out.println(actual);
            actual = actual.siguiente;
        }
    }

}
