package com.simplesoccer;

import com.simplesoccer.view.viewCoach;
import com.simplesoccer.view.viewDoctor;
import com.simplesoccer.view.viewPlayer;
import com.simplesoccer.view.viewTeam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();
        Controller ctrlDoctor = new Controller();
        Controller ctrlCoach = new Controller();

        viewTeam.controlador = ctrlTeams;
        viewPlayer.controlador = ctrlPlayers;
        viewDoctor.controlador = ctrlDoctor;
        viewCoach.controlador = ctrlCoach;

        viewTeam vt = new viewTeam();
        viewPlayer vp = new viewPlayer();
        viewDoctor vd = new viewDoctor();
        viewCoach vc = new viewCoach();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("---------------------------------------\n" +
            "        Gestion general        \n" +
            "---------------------------------------\n" +
            "1. Equipos\n" +
            "2. Jugadores\n" +
            "3. Doctores\n" +
            "4. Entrenadores\n" +
            "5. Salir\n" +
            "Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    vt.start();
                    break;
                case 2:
                    vp.start();
                    break;
                case 3:
                    vd.start();
                    break;
                case 4:
                    vc.start();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
                    break;
            }
        }
    }
}
