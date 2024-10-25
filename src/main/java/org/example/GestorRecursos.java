package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorRecursos {
    private List<RecursoTIC> recursos;

    public GestorRecursos() {
        recursos = new ArrayList<>();
    }

    // Método para agregar un nuevo recurso TIC a la lista con validación de código único.
    public boolean agregarRecurso(RecursoTIC recurso) {
        // Verificar si ya existe un recurso con el mismo código.
        if (buscarRecurso(recurso.getCodigo()) != null) {
            System.out.println("Error: Ya existe un recurso con el código " + recurso.getCodigo());
            return false; // Indicar que la operación falló.
        }

        // Si el código es único, agregar el recurso.
        recursos.add(recurso);
        System.out.println("Recurso agregado correctamente.");
        return true; // Indicar que la operación fue exitosa.
    }

    // Método para listar todos los recursos TIC en formato tabular.
    public void listarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos registrados.");
            return;
        }

        // Imprimir el encabezado de la tabla.
        System.out.printf("%-10s %-20s %-15s %-15s%n", "Código", "Nombre", "Tipo", "Estado");
        System.out.println("---------------------------------------------------------------");

        // Imprimir cada recurso en formato tabular.
        for (RecursoTIC recurso : recursos) {
            System.out.printf("%-10s %-20s %-15s %-15s%n",
                    recurso.getCodigo(),
                    recurso.getNombre(),
                    recurso.getTipo(),
                    recurso.getEstado().name()  // Convierte el enum a su representación en string.
            );
        }
    }

    // Método para buscar un recurso TIC por su código.
    public RecursoTIC buscarRecurso(String codigo) {
        for (RecursoTIC recurso : recursos) {
            if (recurso.getCodigo().equals(codigo)) {
                return recurso; // Se encontró el recurso.
            }
        }
        return null; // No se encontró el recurso.
    }

    // Método para actualizar un recurso existente, buscando por su código.
    public boolean actualizarRecurso(String codigo, RecursoTIC nuevoRecurso) {
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i).getCodigo().equals(codigo)) {
                recursos.set(i, nuevoRecurso); // Actualizar el recurso.
                return true; // Operación exitosa.
            }
        }
        return false; // No se encontró el recurso.
    }

    // Método para mostrar un recurso encontrado en formato tabular.
    public void mostrarRecursoEncontrado(String codigo) {
        RecursoTIC recurso = buscarRecurso(codigo);

        if (recurso != null) {
            System.out.printf("%-10s %-20s %-15s %-15s%n", "Código", "Nombre", "Tipo", "Estado");
            System.out.println("---------------------------------------------------------------");

            System.out.printf("%-10s %-20s %-15s %-15s%n",
                    recurso.getCodigo(),
                    recurso.getNombre(),
                    recurso.getTipo(),
                    recurso.getEstado().name()
            );
        } else {
            System.out.println("Recurso no encontrado.");
        }
    }
}
