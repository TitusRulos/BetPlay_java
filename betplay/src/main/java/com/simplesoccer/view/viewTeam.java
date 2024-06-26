package com.simplesoccer.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.simplesoccer.Controller;
import com.simplesoccer.entity.Coach;
import com.simplesoccer.entity.Doctor;
import com.simplesoccer.entity.Player;
import com.simplesoccer.entity.Team;

public class viewTeam {
    public static Controller controlador;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;

        while (true) {
            System.out.println("---------------------------------------\n" +
            "        Gestion de Equipos        \n" +
            "---------------------------------------\n" +
            "1. Crear Equipo\n" +
            "2. Actualizar Equipo\n" +
            "3. Buscar Equipo\n" +
            "4. Eliminar Equipo\n" +
            "5. Listar todos Equipos\n" +
            "6. Salir\n" +
            "\n" +
            "Ingrese una opción: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    crearEquipo();
                    break;
                case 2:
                    actualizarEquipo();
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
                    return;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        }
    }

    private void crearEquipo() {
        System.out.print("Ingrese el codigo del equipo: ");
        int codigoEquipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Ingrese Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();

        System.out.print("Ingrese la ciudad: ");
        String ciudadEquipo = scanner.nextLine();

        Team equipo = new Team(codigoEquipo, nombreEquipo, ciudadEquipo);
        ArrayList<Player> jugadores = new ArrayList<>();
        ArrayList<Coach> entrenadores = new ArrayList<>();
        ArrayList<Doctor> masajistas = new ArrayList<>();

        agregarJugadores(jugadores);
        equipo.setListJugadores(jugadores);

        agregarEntrenadores(entrenadores);
        equipo.setListEntrenadores(entrenadores);

        agregarMasajistas(masajistas);
        equipo.setListMasajistas(masajistas);

        controlador.equipos.put(codigoEquipo, equipo);
        System.out.println("Equipo creado exitosamente.");
    }

    private void agregarJugadores(ArrayList<Player> jugadores) {
        while (true) {
            System.out.print("Ingrese el ID del jugador: ");
            int idJugador = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Player jugador = new Player();
            jugador.setId(idJugador);
            jugadores.add(jugador);

            System.out.println("¿Quieres agregar otro jugador? \n 1. Si \n 2. No");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarEntrenadores(ArrayList<Coach> entrenadores) {
        while (true) {
            System.out.print("Ingrese el ID del entrenador: ");
            int idEntrenador = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Coach entrenador = new Coach();
            entrenador.setId(idEntrenador);
            entrenadores.add(entrenador);

            System.out.println("¿Quieres agregar otro entrenador? \n 1. Si \n 2. No");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (opcion == 2) {
                break;
            }
        }
    }

    private void agregarMasajistas(ArrayList<Doctor> masajistas) {
        while (true) {
            System.out.print("Ingrese el ID del masajista: ");
            int idMasajista = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Doctor masajista = new Doctor();
            masajista.setId(idMasajista);
            masajistas.add(masajista);

            System.out.println("¿Quieres agregar otro masajista? \n 1. Si \n 2. No");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (opcion == 2) {
                break;
            }
        }
    }

    private void actualizarEquipo() {
        System.out.print("Ingrese el codigo del equipo a actualizar: ");
        int codigoEquipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (controlador.equipos.containsKey(codigoEquipo)) {
            System.out.println("Equipo existente encontrado. Se procederá a eliminar y crear uno nuevo.");

            controlador.equipos.remove(codigoEquipo);

            crearEquipo();
        } else {
            System.out.println("El equipo con el código " + codigoEquipo + " no existe.");
        }
    }

    private void buscarEquipo() {
        boolean encontrado = false;

        while (!encontrado) {
            System.out.print("Ingrese el codigo del equipo a buscar (0 para salir): ");
            int codeEquipo = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (codeEquipo == 0) {
                System.out.println("Saliendo...");
                return;
            }

            if (controlador.equipos.containsKey(codeEquipo)) {
                Team eq = controlador.equipos.get(codeEquipo);
                System.out.println("Nombre: " + eq.getNombre());
                System.out.println("Ciudad: " + eq.getCiudad());
                System.out.println("Jugadores: " + eq.getListJugadores());
                System.out.println("Entrenadores: " + eq.getListEntrenadores());
                System.out.println("Masajistas: " + eq.getListMasajistas());
                encontrado = true;
            } else {
                System.out.println("El equipo con el ID " + codeEquipo + " no existe.");
            }
        }
    }

    private void eliminarEquipo() {
        System.out.print("Ingrese el id del equipo a eliminar: ");
        int idEquipoEliminar = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (controlador.equipos.containsKey(idEquipoEliminar)) {
            controlador.equipos.remove(idEquipoEliminar);
            System.out.println("El equipo ha sido eliminado.");
        } else {
            System.out.println("El equipo con ID " + idEquipoEliminar + " no existe.");
        }
    }

    private void listarEquipos() {
        System.out.println("Lista de todos los equipos:");
        for (int codigo : controlador.equipos.keySet()) {
            Team eq = controlador.equipos.get(codigo);
            System.out.println("");
            System.out.println("Codigo: " + codigo);
            System.out.println("Nombre: " + eq.getNombre());
            System.out.println("Ciudad: " + eq.getCiudad());
        }
    }
}
