package adivinaJugador.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JugadorController {

    public static int puntosTotales = 0;

    public static void jugar() {
        Scanner in = new Scanner(System.in);

        try {
            Scanner jug = new Scanner(new File("jugadores.txt"));

            System.out.println("\n ¡Bienvenido al juego de adivinar el jugador!\n");

            boolean seguir = true;

            while (seguir && jug.hasNextLine()) {
                String linea = jug.nextLine();
                String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int puntos = Integer.parseInt(partes[2]);

                String[] pistas = new String[5];
                int i = 0;

                Scanner pit = new Scanner(new File("pistes.txt"));
                boolean jugadorEncontrado = false;
                while (pit.hasNextLine()) {
                    String texto = pit.nextLine().trim();

                    if (texto.equals("#" + id)) {
                        jugadorEncontrado = true;
                        continue;
                    }

                    if (jugadorEncontrado) {
                        if (texto.startsWith("#")) break;
                        if (!texto.isEmpty()) {
                            pistas[i] = texto;
                            i++;
                        }
                    }
                }
                pit.close();

                boolean acierto = false;
                int intentos = 5;
                int puntosRestantes = puntos;

                for (int p = 0; p < i && intentos > 0; p++) {
                    System.out.println("Pista " + (p + 1) + ": " + pistas[p]);
                    System.out.print("¿Quién crees que es?: ");
                    String resp = in.nextLine().trim().toLowerCase();

                    if (resp.equals(nombre.toLowerCase())) {
                        System.out.println("¡Correcto! Era " + nombre);
                        System.out.println("Has ganado " + puntosRestantes + " puntos.\n");
                        puntosTotales += puntosRestantes;
                        acierto = true;
                        break;
                    } else {
                        intentos--;
                        puntosRestantes -= 10;
                        System.out.println("Incorrecto. Te quedan " + intentos + " intentos.\n");
                    }
                }

                if (!acierto) {
                    System.out.println("Era " + nombre + "\n");
                }

                System.out.println("Puntos actuales: " + puntosTotales);

                System.out.print("¿Quieres jugar otra ronda? (si/no): ");
                String respuesta = in.nextLine().trim().toLowerCase();
                if (!respuesta.equals("si")) seguir = false;
            }

            jug.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivos no encontrados. Asegúrate de tener jugadores.txt y pistes.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Fin del juego. Has conseguido " + puntosTotales + " puntos.");
    }
}
