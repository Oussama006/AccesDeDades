package cat.dam.model;

import java.util.Date;

import org.bson.Document;

public class Cotxe {

    private String marca;
    private String model;
    private int potenciaCV;
    private double preu;
    private Date dataAlta;
    private boolean disponible;
    private String descripcio;

    public Cotxe(String marca, String model, int potenciaCV,
            double preu, Date dataAlta,
            boolean disponible, String descripcio) {
        this.marca = marca;
        this.model = model;
        this.potenciaCV = potenciaCV;
        this.preu = preu;
        this.dataAlta = dataAlta;
        this.disponible = disponible;
        this.descripcio = descripcio;
    }

    public Document toDocument() {
        return new Document("marca", marca)
                .append("model", model)
                .append("potenciaCV", potenciaCV)
                .append("preu", preu)
                .append("dataAlta", dataAlta)
                .append("disponible", disponible)
                .append("descripcio", descripcio);
    }
}
