package adivinaJugador.model;

import java.io.*;
import java.util.*;

public class GestorArchivos {

    public static void verPuntos() {
        try {
            File f = new File("users.dat");
            if (!f.exists()) {
                System.out.println("No hay usuarios registrados todavía.");
                return;
            }

            DataInputStream dis = new DataInputStream(new FileInputStream(f));
            System.out.println("\n--- USUARIOS REGISTRADOS ---");
            while (dis.available() > 0) {
                String nom = dis.readUTF();
                int contra = dis.readInt();
                int puntos = 0;
                System.out.println("Usuario: " + nom + " | Contraseña: " + contra + " | Puntos: " + puntos);
            }
            dis.close();

        } catch (Exception e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
    }
    
}
