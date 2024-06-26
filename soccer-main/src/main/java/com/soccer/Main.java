package com.soccer;

import com.soccer.view.viewTeam;

public class Main {
    package com.soccer.view;

import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Team;

public class ViewTeam {
    public static Controller controlador;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        viewTeam vt = new viewTeam();

        while (true) {
            System.out.println("1. Team");
            System.out.println("2. Player");
            System.out.println("3. Doctor");
            System.out.println("4. Coach");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    start.vt();
                    break;

                case 2:
                    start.vp();
                    break;

                case 3:
                    buscarEquipo();
                    break;

                case 4:
                    eliminarEquipo();
                    break;

                case 5:
                    listarEquipos();
                    break;

                case 6:
                    scanner.close();
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 6.");
            }
        }
    }

    // Función para crear un equipo
    private void crearEquipo() {
        Team equipo = new Team();
        String codigoEquipo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el código del equipo:");
        codigoEquipo = scanner.nextLine();
        System.out.println("Ingrese el nombre del equipo:");
        equipo.setNombre(scanner.nextLine());
        System.out.println("Ingrese la ciudad:");
        equipo.setCiudad(scanner.nextLine());

        controlador.equipos.put(codigoEquipo, equipo);
        System.out.println("Equipo creado exitosamente.");
    }

    // Función para actualizar un equipo
    private void actualizarEquipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el código del equipo que desea actualizar:");
        String codigoEquipo = scanner.nextLine();

        if (controlador.equipos.containsKey(codigoEquipo)) {
            Team equipo = controlador.equipos.get(codigoEquipo);

            System.out.println("Ingrese el nuevo nombre del equipo:");
            equipo.setNombre(scanner.nextLine());
            System.out.println("Ingrese la nueva ciudad:");
            equipo.setCiudad(scanner.nextLine());

            controlador.equipos.put(codigoEquipo, equipo);
            System.out.println("Equipo actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún equipo con ese código.");
        }
    }

    // Función para buscar un equipo
    private void buscarEquipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el código del equipo que desea buscar:");
        String codigoEquipo = scanner.nextLine();

        if (controlador.equipos.containsKey(codigoEquipo)) {
            Team equipo = controlador.equipos.get(codigoEquipo);
            System.out.println("Nombre del equipo: " + equipo.getNombre());
            System.out.println("Ciudad: " + equipo.getCiudad());
        } else {
            System.out.println("No se encontró ningún equipo con ese código.");
        }
    }

    // Función para eliminar un equipo
    private void eliminarEquipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el código del equipo que desea eliminar:");
        String codigoEquipo = scanner.nextLine();

        if (controlador.equipos.containsKey(codigoEquipo)) {
            controlador.equipos.remove(codigoEquipo);
            System.out.println("Equipo eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún equipo con ese código.");
        }
    }

    // Función para listar todos los equipos
    private void listarEquipos() {
        if (controlador.equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            System.out.println("Lista de equipos:");
            for (String codigo : controlador.equipos.keySet()) {
                Team equipo = controlador.equipos.get(codigo);
                System.out.println("Código: " + codigo + ", Nombre: " + equipo.getNombre() + ", Ciudad: " + equipo.getCiudad());
            }
        }
    }
}

}