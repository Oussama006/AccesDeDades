import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class exemple {
    public static void main(String[] args) {
       
   
        System.out.println("Benvingut al joc!");
       
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("users.dat")));
            User usr1 = new User("oussama", "1234");
            oos.writeObject(usr1);
            System.out.println("Usuari creat: " + usr1.nom);

            User usr2 = new User("pepe", "1234");
            oos.writeObject(usr2);
            System.out.println("Usuari creat: " + usr2.nom);

            User usr3 = new User("toto", "1234");
            oos.writeObject(usr3);
            System.out.println("Usuari creat: " + usr3.nom);
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("users.dat")));
            User u = (User) ois.readObject();
            System.out.println("Usuari llegit: " + u.nom);
            // .println("Usuari llegit: " + u.nom);
            u = (User) ois.readObject();
            u = (User) ois.readObject();
            u = (User) ois.readObject();
            System.out.println("Usuari llegit: " + u.nom);
            System.out.println("Usuari llegit: " + u.nom);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}