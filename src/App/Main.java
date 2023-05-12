package App;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        Libro libro1 = new Libro("9788808188644", "1984", 1949, 352, "George Orwell", "Romanzo distopico");
        Libro libro2 = new Libro("9788804684982", "Il nome della rosa", 1980, 528, "Umberto Eco", "Romanzo storico");
        Libro libro3 = new Libro("9788808865848", "La fattoria degli Animali", 1945, 422, "George Orwell", "Romanzo allegorico");
        Rivista rivista1 = new Rivista("9771122649008", "Wired Italia", 2023, 100, Rivista.Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("9772286505004", "La natura", 2021, 50, Rivista.Periodicita.SETTIMANALE);
        Rivista rivista3 = new Rivista("9849495498467", "Il buco nero della Via Lattea un anno dopo", 2022,20 , Rivista.Periodicita.SEMESTRALE);
        
        catalogo.aggiungiElemento(libro1);
        catalogo.aggiungiElemento(libro2);
        catalogo.aggiungiElemento(libro3);
        catalogo.aggiungiElemento(rivista1);
        catalogo.aggiungiElemento(rivista2);
        catalogo.aggiungiElemento(rivista3);

        System.out.println("Elementi nel catalogo: ");
        for (ElementoCatalogo elemento : catalogo.getElementi()) {
            if (elemento instanceof Libro) {
                Libro libro = (Libro) elemento;
                System.out.println("Libro: " + libro.getTitolo() + " (" + libro.getAutore() + ")");
                System.out.println("GENERE: " + libro.getGenere());
                System.out.println("ANNO DI PUBBLICAZIONE: " + libro.getAnnoPubblicazione());
                System.out.println("Codice ISBN: " + libro.getCodiceISBN());
                System.out.println("Numero pagine: " + libro.getNumeroPagine());
            } else if (elemento instanceof Rivista) {
                Rivista rivista = (Rivista) elemento;
                System.out.println("Rivista: " + rivista.getTitolo() + " (" + rivista.getPeriodicita() + ")");
                System.out.println("ANNO DI PUBBLICAZIONE: " + rivista.getAnnoPubblicazione());
                System.out.println("Codice ISBN: " + rivista.getCodiceISBN());
                System.out.println("Numero pagine: " + rivista.getNumeroPagine());
            }
            System.out.println(); // Linea vuota per separare gli elementi
        }

        System.out.println("Libri dell'autore George Orwell:");
        List<Libro> libriOrwell = catalogo.cercaLibriPerAutore("George Orwell");
        for (Libro libro : libriOrwell) {
            System.out.println("- " + libro.getTitolo() + " (Codice ISBN: " + libro.getCodiceISBN() + ", Numero pagine: " + libro.getNumeroPagine() + ")");
        }

        System.out.println("Riviste mensili:");
        List<Rivista> rivisteMensili = catalogo.cercaRivistePerPeriodicita(Rivista.Periodicita.MENSILE);
        for (Rivista rivista : rivisteMensili) {
            System.out.println("- " + rivista.getTitolo() + " (Codice ISBN: " + rivista.getCodiceISBN() + ", Numero pagine: " + rivista.getNumeroPagine() + ")");
        }
    }
}
