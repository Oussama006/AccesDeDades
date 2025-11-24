package dam.m6.uf2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class ConnectionManager {

    public static Connection openConnection() {
        return getConnection("database.xml");
    }

    public static Connection getConnection(String xmlFile) {

        try {
            File file = new File(xmlFile);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            String host = doc.getElementsByTagName("host").item(0).getTextContent();
            String port = doc.getElementsByTagName("port").item(0).getTextContent();
            String db = doc.getElementsByTagName("database").item(0).getTextContent();
            String user = doc.getElementsByTagName("user").item(0).getTextContent();
            String pass = doc.getElementsByTagName("password").item(0).getTextContent();

            String url = "jdbc:postgresql://" + host + ":" + port + "/" + db;

            return DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("ERROR en ConnectionManager: " + e.getMessage());
            return null;
        }
    }
}
