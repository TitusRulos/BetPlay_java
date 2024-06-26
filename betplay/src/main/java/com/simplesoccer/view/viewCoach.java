package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Coach;
import java.util.Scanner;

public class viewCoach {
    public static Controller controlador;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int op;

        while (true) {
            System.out.println("---------------------------------------\n" +
            "        Gestion de Entrenadores        \n" +
            "---------------------------------------\n" +
            "1. Crear Entrenador\n" +
            "2. Actualizar Entrenador\n" +
            "3. Eliminar Entrenador\n" +
            "4. Listar todos los Entrenadores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");
            op = scanner.nextInt();
            scanner.nextLine(); 

            switch (op) {
                case 1:
                    crearEntrenador();
                    break;

                case 2:
                    actualizarEntrenador();
                    break;

                case 3:
                    eliminarEntrenador();
                    break;

                case 4:
                    listarEntrenadores();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        }
    }

    private void crearEntrenador() {
        System.out.print("Ingrese el código del Entrenador: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el Nombre del Entrenador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos del Entrenador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Entrenador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la ID de la federacion: ");
        int federacion = scanner.nextInt();
        scanner.nextLine();

        Coach nuevoEntrenador = new Coach(id, nombre, apellido, edad, federacion);
        controlador.entrenadores.put(id, nuevoEntrenador);

        System.out.println("");
        System.out.println("Entrenador creado exitosamente.");
    }

    private void actualizarEntrenador() {
        System.out.print("Ingrese el código del Entrenador a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (controlador.entrenadores.containsKey(id)) {
            System.out.println("Entrenador existente encontrado. Se procederá a actualizar con nuevos datos.");
            controlador.entrenadores.remove(id);
        } else {
            System.out.println("No se encontró un entrenador con ese ID. Se procederá a crear uno nuevo.");
        }

        System.out.print("Ingrese el Nombre del Entrenador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos del Entrenador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Entrenador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la ID de la federacion: ");
        int federacion = scanner.nextInt();
        scanner.nextLine();

        Coach nuevoEntrenador = new Coach(id, nombre, apellido, edad, federacion);
        controlador.entrenadores.put(id, nuevoEntrenador);

        System.out.println("");
        System.out.println("Entrenador actualizado exitosamente.");
    }

    private void eliminarEntrenador() {
        System.out.print("Ingrese el código del Entrenador a Eliminar: ");
        int codigoEntrenadorElim = scanner.nextInt();
        scanner.nextLine();

        if (controlador.entrenadores.containsKey(codigoEntrenadorElim)) {
            Coach entrenadorElim = controlador.entrenadores.get(codigoEntrenadorElim);
            System.out.println("Entrenador: " + entrenadorElim.getNombre() + " " + entrenadorElim.getApellido());
            System.out.println("Edad: " + entrenadorElim.getEdad());
            System.out.println("ID federación: " + entrenadorElim.getIdFederacion());
            System.out.println("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = scanner.nextInt();
            scanner.nextLine(); 

            if (conf == 1) {
                controlador.entrenadores.remove(codigoEntrenadorElim);
                System.out.println("Entrenador eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El entrenador con código " + codigoEntrenadorElim + " no existe!");
        }
    }

    private void listarEntrenadores() {
        System.out.println("Listado de Entrenadores: ");
        for (Integer key : controlador.entrenadores.keySet()) {
            Coach currentEntrenadores = controlador.entrenadores.get(key);
            System.out.println("");
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentEntrenadores.getNombre());
            System.out.println("Apellido: " + currentEntrenadores.getApellido());
            System.out.println("Edad: " + currentEntrenadores.getEdad());
            System.out.println("ID Federación: " + currentEntrenadores.getIdFederacion());
        }
    }
}
