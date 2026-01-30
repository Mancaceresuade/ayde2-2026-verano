// TAD Conjunto: implementacion estatica
public class Conjunto {
    String[] nombres;
    int puntero = 0;
    public Conjunto(int cantidad) {
        this.nombres = new String[cantidad];
    }
    public void agregar(String nombre) {
        if(estaRepetido(nombre)) new RuntimeException("Esta repetido");
        nombres[puntero] = nombre;
        puntero++;
    }
    private boolean estaRepetido(String nombre) {
        boolean rta = false;
        for (int i = 0; i < (puntero); i++) {
            if(nombres[i].equals(nombre)) rta = true;
        }
        return rta;
    } // complejidad ? O(n)
    public void imprimir() {
        for (int i = 0; i < (puntero); i++) {
            System.out.println(nombres[i]);
        }
    }
}    
