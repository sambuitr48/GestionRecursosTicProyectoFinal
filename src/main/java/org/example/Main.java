package org.example;

import java.util.Scanner;

// La clase Main contiene el método principal para la interacción con el usuario.
public class Main {
    public static void main(String[] args) {
        // Crear una instancia del GestorRecursos.
        GestorRecursos gestor = new GestorRecursos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Ciclo para mostrar el menú hasta que el usuario decida salir.
        do {
            // Mostrar el menú al usuario.
            System.out.println("Bienvenido al gestor de recursos TIC de la CUE c:");
            System.out.println("1. Agregar Recurso");
            System.out.println("2. Listar Recursos");
            System.out.println("3. Actualizar Recurso");
            System.out.println("4. Buscar Recurso");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea.

            switch (opcion) {
                case 1:
                    // Opción para agregar un nuevo recurso TIC.
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();

                    // Selección del estado usando el Enum.
                    System.out.println("Elige el estado: ");
                    System.out.println("1. DISPONIBLE");
                    System.out.println("2. EN_USO");
                    System.out.println("3. EN_REPARACION");
                    int estadoOpcion = scanner.nextInt();
                    EstadoRecurso estado = null;
                    switch (estadoOpcion) {
                        case 1:
                            estado = EstadoRecurso.DISPONIBLE;
                            break;
                        case 2:
                            estado = EstadoRecurso.EN_USO;
                            break;
                        case 3:
                            estado = EstadoRecurso.EN_REPARACION;
                            break;
                        default:
                            System.out.println("Opción de estado no válida.");
                            continue;
                    }

                    // Crear un nuevo recurso y tratar de agregarlo al gestor.
                    RecursoTIC nuevoRecurso = new RecursoTIC(codigo, nombre, tipo, estado);
                    gestor.agregarRecurso(nuevoRecurso);
                    break;


                case 2:
                    // Opción para listar todos los recursos TIC.
                    System.out.println("Lista de Recursos TIC:");
                    gestor.listarRecursos();
                    break;

                case 3:
                    // Opción para actualizar un recurso existente.
                    System.out.print("Ingresa el código del recurso a actualizar: ");
                    String codigoBuscar = scanner.nextLine();

                    RecursoTIC recursoEncontrado = gestor.buscarRecurso(codigoBuscar);
                    if (recursoEncontrado != null) {
                        // Solicitar nuevos datos del recurso.
                        System.out.print("Nuevo Nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nuevo Tipo: ");
                        String nuevoTipo = scanner.nextLine();

                        // Selección del nuevo estado usando el Enum.
                        System.out.println("Elige el nuevo estado: ");
                        System.out.println("1. DISPONIBLE");
                        System.out.println("2. EN_USO");
                        System.out.println("3. EN_REPARACION");
                        int nuevoEstadoOpcion = scanner.nextInt();
                        EstadoRecurso nuevoEstado = null;
                        switch (nuevoEstadoOpcion) {
                            case 1:
                                nuevoEstado = EstadoRecurso.DISPONIBLE;
                                break;
                            case 2:
                                nuevoEstado = EstadoRecurso.EN_USO;
                                break;
                            case 3:
                                nuevoEstado = EstadoRecurso.EN_REPARACION;
                                break;
                            default:
                                System.out.println("Opción de estado no válida.");
                                continue;
                        }

                        // Actualizar los datos del recurso.
                        RecursoTIC recursoActualizado = new RecursoTIC(codigoBuscar, nuevoNombre, nuevoTipo, nuevoEstado);
                        gestor.actualizarRecurso(codigoBuscar, recursoActualizado);
                        System.out.println("Recurso actualizado correctamente.");
                    } else {
                        System.out.println("Recurso no encontrado.");
                    }
                    break;

                case 4:
                    // Opción para buscar un recurso por su código.
                    System.out.print("Ingresa el código del recurso a buscar: ");
                    String codigoABuscar = scanner.nextLine();
                    gestor.mostrarRecursoEncontrado(codigoABuscar);
                    break;


                case 5:
                    // Opción para salir del programa.
                    System.out.println("Chao profeee");
                    break;

                default:
                    System.out.println("Opción no válida, inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 5); // El programa sigue hasta que el usuario elija la opción 5.

        scanner.close(); // Cerrar el escáner.
    }
}
