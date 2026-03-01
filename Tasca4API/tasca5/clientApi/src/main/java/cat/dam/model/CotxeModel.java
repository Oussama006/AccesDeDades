package cat.dam.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

public class CotxeModel {

    private static final String APIURL = "http://localhost:3021";

    private final HttpClient client = HttpClient.newHttpClient();
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String cotxeToJson(Cotxe c) {

        SimpleDateFormat sdfIso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"marca\":\"").append(c.getMarca().replace("\"", "\\\"")).append("\",");
        sb.append("\"model\":\"").append(c.getModel().replace("\"", "\\\"")).append("\",");
        sb.append("\"potenciaCV\":").append(c.getPotenciaCV()).append(",");
        sb.append("\"preu\":").append(c.getPreu()).append(",");
        sb.append("\"dataAlta\":\"").append(sdfIso.format(c.getDataAlta())).append("\",");
        sb.append("\"disponible\":").append(c.isDisponible()).append(",");
        sb.append("\"descripcio\":\"").append(c.getDescripcio().replace("\"", "\\\"")).append("\"");
        sb.append("}");
        return sb.toString();
    }

    public CompletableFuture<Void> inserirCotxe(Cotxe c) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + "/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(cotxeToJson(c)))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenAccept(response -> {
                });
    }

    public CompletableFuture<Void> updateCotxe(ObjectId id, Cotxe c) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + "/update/" + id.toString()))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(cotxeToJson(c)))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenAccept(response -> {
                });
    }

    public CompletableFuture<Void> deleteCotxe(ObjectId id) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + "/delete/" + id.toString()))
                .DELETE()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.discarding())
                .thenAccept(response -> {
                });
    }

    public List<Document> getAll() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + "/list"))
                .GET()
                .build();

        try {
            String body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();

            return parseJson(body);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Document> getFilteredByModel(String text) {

        List<Document> tots = getAll();
        List<Document> filtrats = new ArrayList<>();

        for (Document d : tots) {

            String marca = d.getString("marca");
            String model = d.getString("model");

            if ((marca != null && marca.toLowerCase().contains(text.toLowerCase()))
                    || (model != null && model.toLowerCase().contains(text.toLowerCase()))) {
                filtrats.add(d);
            }
        }

        return filtrats;
    }

    public List<Document> getByDate(Date inici, Date fi) {

        String i = sdf.format(inici);
        String f = sdf.format(fi);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIURL + "/list/" + i + "/" + f))
                .GET()
                .build();

        try {
            String body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .join();

            return parseJson(body);

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Document> parseJson(String json) {

        List<Document> llista = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                llista.add(Document.parse(obj.toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return llista;
    }
}
