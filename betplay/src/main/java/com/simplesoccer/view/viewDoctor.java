package com.simplesoccer.view;

import com.simplesoccer.Controller;
import com.simplesoccer.entity.Doctor;
import java.util.Scanner;

public class viewDoctor {
    public static Controller controlador;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int op;

        while (true) {
            System.out.println("---------------------------------------\n" +
            "        Gestion de Doctores        \n" +
            "---------------------------------------\n" +
            "1. Crear Doctor\n" +
            "2. Actualizar Doctor\n" +
            "3. Eliminar Doctor\n" +
            "4. Listar todos los Doctores\n" +
            "5. Salir\n" +
            "\n" +
            "Ingrese una opción: ");
            op = scanner.nextInt();
            scanner.nextLine(); 

            switch (op) {
                case 1:
                    crearDoctor();
                    break;

                case 2:
                    actualizarDoctor();
                    break;

                case 3:
                    eliminarDoctor();
                    break;

                case 4:
                    listarDoctores();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        }
    }

    private void crearDoctor() {
        System.out.print("Ingrese el código del Doctor: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el Nombre del Doctor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos del Doctor: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Doctor: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 


        Doctor nuevoDoctor = new Doctor(id, nombre, apellido, edad);
        controlador.doctores.put(id, nuevoDoctor);

        System.out.println("");
        System.out.println("Doctor creado exitosamente.");
    }

    private void actualizarDoctor() {
        System.out.print("Ingrese el código del Doctor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (controlador.doctores.containsKey(id)) {
            System.out.println("Doctor existente encontrado. Se procederá a actualizar con nuevos datos.");
            controlador.doctores.remove(id);
        } else {
            System.out.println("No se encontró un doctor con ese ID. Se procederá a crear uno nuevo.");
        }

        System.out.print("Ingrese el Nombre del Doctor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese Apellidos del Doctor: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la Edad del Doctor: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        Doctor nuevoDoctor = new Doctor(id, nombre, apellido, edad);
        controlador.doctores.put(id, nuevoDoctor);

        System.out.println("");
        System.out.println("Doctor actualizado exitosamente.");
    }

    private void eliminarDoctor() {
        System.out.print("Ingrese el código del Doctor a Eliminar: ");
        int codigoDoctorElim = scanner.nextInt();
        scanner.nextLine();

        if (controlador.doctores.containsKey(codigoDoctorElim)) {
            Doctor doctorElim = controlador.doctores.get(codigoDoctorElim);
            System.out.println("Doctor: " + doctorElim.getNombre() + " " + doctorElim.getApellido());
            System.out.println("Edad: " + doctorElim.getEdad());
            System.out.println("¿Seguro quieres eliminarlo?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int conf = scanner.nextInt();
            scanner.nextLine(); 

            if (conf == 1) {
                controlador.doctores.remove(codigoDoctorElim);
                System.out.println("Doctor eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("El doctor con código " + codigoDoctorElim + " no existe!");
        }
    }

    private void listarDoctores() {
        System.out.println("Listado de Doctores: ");
        for (Integer key : controlador.doctores.keySet()) {
            Doctor currentDoctor = controlador.doctores.get(key);
            System.out.println("");
            System.out.println("Código: " + key);
            System.out.println("Nombre: " + currentDoctor.getNombre());
            System.out.println("Apellido: " + currentDoctor.getApellido());
            System.out.println("Edad: " + currentDoctor.getEdad());
        }
    }
}
