package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Player;
import java.util.Scanner;

public class viewPlayer {
    public static Controller controlador;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int op;

        while (true) {
            System.out.println("---------------------------------------\n" +
            "        Gestión de Jugadores        \n" +
            "---------------------------------------\n" +
            "1. Crear Jugador\n" +
            "2. Actualizar Jugador\n" +
            "3. Eliminar Jugador\n" +
            "4. Listar todos los Jugadores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");
            op = scanner.nextInt();
            scanner.nextLine(); 

            switch (op) {
                case 1:
                    crearJugador();
                    break;

                case 2:
                    actualizarJugador();
                    break;

                case 3:
                    eliminarJugador();
                    break;

                case 4:
                    listarJugadores();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        }
    }

    private void crearJugador() {
        System.out.print("Ingrese el ID del Jugador: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el Nombre del Jugador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el Apellido del Jugador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Jugador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el Dorsal del Jugador: ");
        int dorsal = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la Posición del Jugador: ");
        String posicion = scanner.nextLine();

        Player nuevoJugador = new Player(id, nombre, apellido, edad, dorsal, posicion);
        controlador.jugadores.put(id, nuevoJugador);

        System.out.println("");
        System.out.println("Jugador creado exitosamente.");
    }

    private void actualizarJugador() {
        System.out.print("Ingrese el ID del Jugador a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (controlador.jugadores.containsKey(id)) {
            System.out.println("Jugador encontrado. Se procederá a actualizar con nuevos datos.");
            controlador.jugadores.remove(id);
        } else {
            System.out.println("No se encontró un jugador con ese ID. Se procederá a crear uno nuevo.");
        }

        System.out.print("Ingrese el Nombre del Jugador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el Apellido del Jugador: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Jugador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el Dorsal del Jugador: ");
        int dorsal = scanner.nextInt();

        System.out.print("Ingrese la Posición del Jugador: ");
        String posicion = scanner.nextLine();

        Player nuevoJugador = new Player(id, nombre, apellido, edad, dorsal, posicion);
        controlador.jugadores.put(id, nuevoJugador);

        System.out.println("");
        System.out.println("Jugador actualizado exitosamente.");
    }

    private void eliminarJugador() {
        System.out.print("Ingrese el ID del Jugador a Eliminar: ");
        int idJugadorElim = scanner.nextInt();
        scanner.nextLine();

        if (controlador.jugadores.containsKey(idJugadorElim)) {
            Player jugadorElim = controlador.jugadores.get(idJugadorElim);
            System.out.println("Jugador: " + jugadorElim.getNombre());
            System.out.println("Edad: " + jugadorElim.getEdad());
            System.out.println("Posición: " + jugadorElim.getPosicion());
            System.out.println("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = scanner.nextInt();
            scanner.nextLine(); 

            if (conf == 1) {
                controlador.jugadores.remove(idJugadorElim);
                System.out.println("Jugador eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El jugador con ID " + idJugadorElim + " no existe!");
        }
    }

    private void listarJugadores() {
        System.out.println("Listado de Jugadores: ");
        for (Integer key : controlador.jugadores.keySet()) {
            Player currentPlayer = controlador.jugadores.get(key);
            System.out.println("");
            System.out.println("ID: " + key);
            System.out.println("Nombre: " + currentPlayer.getNombre());
            System.out.println("Edad: " + currentPlayer.getEdad());
            System.out.println("Posición: " + currentPlayer.getPosicion());
        }
    }
}
