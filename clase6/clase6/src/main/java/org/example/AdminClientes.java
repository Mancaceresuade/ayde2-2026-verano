package org.example;

import java.util.ArrayList;
import java.util.List;

// TAD Administrador de Clientes
// Datos: Lista de Clientes
// Operaciones: agregarCliente, eliminarCliente, buscarCliente, listarClientes
// Invariante: No puede haber clientes con el mismo número de identificación
public class AdminClientes {
    List<Cliente> clientes;
    public AdminClientes() {
        clientes = new ArrayList<>();
    }
    public void agregarCliente(Cliente cliente) {
        if(buscarCliente(cliente.numeroId) ) { // O(n)
            throw new RuntimeException("El cliente con número de identificación " + cliente.numeroId + " ya existe");
        }
        clientes.add(cliente); // O(1)
    } // Complejidad , caso  promedio O(n)

    private boolean buscarCliente(Integer numeroId) {
        for (Cliente cliente : clientes) {
            if (cliente.numeroId.equals(numeroId)) {
                return true;
            }
        }
        return false;
    } // Complejidad O(n)

}
