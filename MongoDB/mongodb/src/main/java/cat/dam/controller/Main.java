package cat.dam.controller;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import cat.dam.model.Cotxe;
import cat.dam.model.CotxeModel;
import cat.dam.view.View;

public class Main {

    public static void main(String[] args) {

        CotxeModel model = new CotxeModel();
        int op;

        do {
            op = View.menu();

            switch (op) {
                case 1 -> {
                    Cotxe c = View.askCotxe();
                    model.inserirCotxe(c);
                }
                case 2 -> {
                    List<Document> docs = model.getAll();
                    ObjectId id = View.seleccionarCotxe(docs);
                    model.deleteCotxe(id);
                }
                case 3 -> {
                    List<Document> docs = model.getAll();
                    ObjectId id = View.seleccionarCotxe(docs);
                    Cotxe c = View.askCotxe();
                    model.updateCotxe(id, c);
                }
                case 4 ->
                    View.mostrarCotxes(model.getAll());
                case 5 -> {
                    Date ini = View.askDate("Data inici");
                    Date fi = View.askDate("Data fi");
                    View.mostrarCotxes(model.getByDate(ini, fi));
                }
                case 6 -> {
                    String text = View.askModel();
                    View.mostrarCotxes(model.getFilteredByModel(text));
                }
            }

        } while (op != 0);
    }
}
