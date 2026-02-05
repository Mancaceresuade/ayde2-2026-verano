package org.example;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
        Cliente cliente = new Cliente("Carlos", null);

        /*
        List<String> nombres = new ArrayList<>();
        nombres.add("Carlos");
        nombres.add("Pedro");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Maria");
        nombres.add("Ana");
        // cuantos nombres hay de cada uno ?
        Map<String, Integer> contadorNombres = new HashMap<>();
        for (String nombre : nombres) {
            if (contadorNombres.containsKey(nombre)) {
                contadorNombres.put(nombre, contadorNombres.get(nombre) + 1);
            } else {
                contadorNombres.put(nombre, 1);
            }
        }
        // contadorNombres.values().forEach(System.out::println);
        for (Map.Entry<String, Integer> entry : contadorNombres.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (String nombre: contadorNombres.keySet()) {
            System.out.println(nombre + ": " + contadorNombres.get(nombre));
        }
        contadorNombres.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
        contadorNombres.entrySet().stream().filter(e -> e.getValue() > 1)
                .forEach(e -> System.out.println(e.getKey()+" : "+e.getValue()));

        System.out.println(contadorNombres.entrySet().stream().filter(e -> e.getValue() > 1)
                .mapToInt(Map.Entry::getValue).sum());

        */

        /*
        Deque<String> deque = new ArrayDeque<>(20);
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");
        System.out.println("Deque contents: " + deque);

        deque.forEach(System.out::println);
        deque.forEach(element -> System.out.println("Element: " + element));

        for (String element : deque)  {
            System.out.println("Element: " + element);
        }

        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            deque.removeFirst();
            System.out.println("Element: " + iterator.next());
        }
        Iterator descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println("Element (reverse): " + descendingIterator.next());
        }
        */
    }
}
