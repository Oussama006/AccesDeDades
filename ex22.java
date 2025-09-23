import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ex22{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Scanner in = new Scanner(System.in);
        String text = "";
        String file = "usertext.txt";

        File f = new File(file);

        do {
            System.out.println("Introdueix un text: ");
            text = in.nextLine();

            if (text.equals("quit")) {
                return;
            }

            FileOutputStream fos = new FileOutputStream(f, true);
            fos.write((text.getBytes()));
            fos.write("\n".getBytes());
            fos.close();

        } while (!text.equals("quit"));

        FileInputStream fis = new FileInputStream(f);

        int n= 0;
        while (n!= -1){
            n = fis.read();
            System.out.print((char)n);
        }
        fis.close();
    }
}