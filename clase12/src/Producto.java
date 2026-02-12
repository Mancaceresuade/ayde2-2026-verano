public class Producto implements Comparable<Producto> {
    int id;
    String nombre;
    @Override
    public int compareTo(Producto o) {
        return Integer.compare(this.id, o.id);
    }
    @Override
    public String toString() {
        return "id: " + id + " nombre: " + nombre;
    }
}
