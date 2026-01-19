package cat.dam;

import java.util.Date;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

public class Main {

    public static void main(String[] args) {

        // PON AQUÍ TU CONTRASEÑA REAL
        String uri = "mongodb+srv://oussamaallali_db_user:MiPass123@cluster0.gf6hsvq.mongodb.net/CotxesEsportius?retryWrites=true&w=majority";

        // Crear cliente y conectar
        MongoClient client = MongoClients.create(uri);
        MongoDatabase db = client.getDatabase("CotxesEsportius");
        MongoCollection<Document> cotxes = db.getCollection("cotxes");

        System.out.println("Connexió correcta a MongoDB Atlas");

        // Insertar un cotxe
        Document cotxe = new Document()
                .append("marca", "Audi")
                .append("model", "RS6 Java")
                .append("potenciaCV", 600)
                .append("preu", 140000)
                .append("dataAlta", new Date())
                .append("disponible", true)
                .append("descripcio", "Cotxe inserit des de Java");

        cotxes.insertOne(cotxe);
        System.out.println("Cotxe inserit");

        // Listar cotxes
        System.out.println("Llistat de cotxes:");
        for (Document d : cotxes.find()) {
            System.out.println(d.toJson());
        }

        // Actualizar cotxe
        cotxes.updateOne(
                eq("model", "RS6 Java"),
                new Document("$set", new Document("disponible", false))
        );
        System.out.println("Cotxe actualitzat");

        // Eliminar cotxe
        cotxes.deleteOne(eq("model", "RS6 Java"));
        System.out.println("Cotxe eliminat");

        // Cerrar conexión
        client.close();
    }
}
