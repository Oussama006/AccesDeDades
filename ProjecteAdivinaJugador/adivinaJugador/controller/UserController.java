package adivinaJugador.controller;

import java.io.*;
import java.util.Scanner;

public class UserController {

    public static void login() {
        Scanner in = new Scanner(System.in);
        System.out.print("Usuario: ");
        String usuario = in.nextLine();
        System.out.print("Contraseña (solo números): ");
        int contra = in.nextInt();
        in.nextLine();

        try {
            File f = new File("users.dat");
            if (!f.exists()) {
                System.out.println("No hay usuarios registrados. Regístrate primero.");
                return;
            }

            DataInputStream dis = new DataInputStream(new FileInputStream(f));
            boolean encontrado = false;

            while (dis.available() > 0) {
                String nom = dis.readUTF();
                int pass = dis.readInt();
                if (nom.equals(usuario) && pass == contra) {
                    System.out.println("Acceso correcto. Bienvenido " + nom + "!");
                    encontrado = true;
                    break;
                }
            }
            dis.close();

            if (!encontrado) {
                System.out.println("Usuario o contraseña incorrectos.");
            }

        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }

    public static void register() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nuevo usuario: ");
        String usuario = in.nextLine();
        System.out.print("Contraseña (solo números): ");
        int contra = in.nextInt();

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("users.dat", true));
            dos.writeUTF(usuario);
            dos.writeInt(contra);
            dos.close();
            System.out.println("Usuario registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }
}
