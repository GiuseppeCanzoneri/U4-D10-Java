package App;
import java.util.ArrayList;
import java.util.List;


public class CatalogoBibliotecario {
    private List<ElementoCatalogo> elementi;

    public CatalogoBibliotecario() {
        elementi = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        elementi.add(elemento);
    }

    public List<ElementoCatalogo> getElementi() {
        return elementi;
    }

    public List<Libro> cercaLibriPerAutore(String autore) {
        List<Libro> libri = new ArrayList<>();
        for (ElementoCatalogo elemento : elementi) {
            if (elemento instanceof Libro && ((Libro) elemento).getAutore().equals(autore)) {
                libri.add((Libro) elemento);
            }
        }
        return libri;
    }

    public List<Rivista> cercaRivistePerPeriodicita(Rivista.Periodicita periodicita) {
        List<Rivista> riviste = new ArrayList<>();
        for (ElementoCatalogo elemento : elementi) {
            if (elemento instanceof Rivista && ((Rivista) elemento).getPeriodicita() == periodicita) {
                riviste.add((Rivista) elemento);
            }
        }
        return riviste;
    }
}
