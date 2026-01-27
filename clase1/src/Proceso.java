import java.util.Scanner;

public class Proceso {
    public static void miFuncion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();
        System.out.println("Su nombre "+nombre);
        scanner.close();
    }

}
