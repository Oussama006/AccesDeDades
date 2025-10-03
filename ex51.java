
import java.io.*;
import java.util.*;

public class ex51 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        RandomAccessFile f = new RandomAccessFile("paises.dat", "rw");

        f.writeUTF("España");
        f.writeUTF("ES");
        f.writeLong(47000000);
        f.writeUTF("Madrid");

        f.writeUTF("Francia");
        f.writeUTF("FR");
        f.writeLong(67000000);
        f.writeUTF("París");

        f.writeUTF("Alemania");
        f.writeUTF("ALE");
        f.writeLong(60000000);
        f.writeUTF("Berlín");

        try {
            int registre = 100;
            System.out.print("Índex del país: ");
            int i = in.nextInt();
            in.nextLine();
            System.out.print("Camp (codi/nom/poblacio/capital): ");
            String camp = in.nextLine();
            System.out.print("Nou valor: ");
            String val = in.nextLine();

            f.seek(i * registre);

            String nom = f.readUTF();
            String codi = f.readUTF();
            long poblacio = f.readLong();
            String capital = f.readUTF();

            if (camp.equalsIgnoreCase("nom")) {
                nom = val;
            } else if (camp.equalsIgnoreCase("codi")) {
                codi = val;
            } else if (camp.equalsIgnoreCase("poblacio")) {
                poblacio = Long.parseLong(val);
            } else if (camp.equalsIgnoreCase("capital")) {
                capital = val;
            }

            f.seek(i * registre);
            f.writeUTF(nom);
            f.writeUTF(codi);
            f.writeLong(poblacio);
            f.writeUTF(capital);
            f.close();
            System.out.println("Modificat!");
        }catch(FileNotFoundException e){
            System.out.println("Eñ fitxer no existeix");
        }catch(IOException e){
            System.out.println("Error d'entrada/sortida");
        }catch(NumberFormatException e){
            System.out.println("Error en el format del número");
        }catch(Exception e){
            System.out.println("Error desconegut");
        }

    }
}
