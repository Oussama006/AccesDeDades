package adivinaJugador.controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Jugar");
            System.out.println("4. Ver mis puntos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    UserController.login();
                    break;
                case 2:
                    UserController.register();
                    break;
                case 3:
                    JugadorController.jugar();
                    break;
                case 4:
                    System.out.println("Tus puntos actuales son: " + JugadorController.puntosTotales);
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);

        in.close();
    }
}
