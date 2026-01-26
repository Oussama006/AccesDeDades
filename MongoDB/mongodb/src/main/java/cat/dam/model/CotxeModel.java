package cat.dam.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CotxeModel {

    private MongoCollection<Document> collection;

    public CotxeModel() {
        MongoDatabase db = ConnectionManager.getConnection().getDatabase("CotxesEsportius");
        collection = db.getCollection("cotxes");
    }

    public void inserirCotxe(Cotxe c) {
        collection.insertOne(c.toDocument());
    }

    public List<Document> getAll() {
        return collection.find().into(new ArrayList<>());
    }

    public void updateCotxe(ObjectId id, Cotxe c) {
        collection.updateOne(
                new Document("_id", id),
                new Document("$set", c.toDocument())
        );
    }

    public void deleteCotxe(ObjectId id) {
        collection.deleteOne(new Document("_id", id));
    }

    public List<Document> getByDate(Date inici, Date fi) {
        return collection.find(
                new Document("dataAlta",
                        new Document("$gte", inici)
                                .append("$lte", fi))
        ).into(new ArrayList<>());
    }

    public List<Document> getFilteredByModel(String text) {
        return collection.find(
                new Document("model",
                        new Document("$regex", text)
                                .append("$options", "i"))
        ).into(new ArrayList<>());
    }
}
