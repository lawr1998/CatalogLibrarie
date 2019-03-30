package ro.sci;

public class Book {

    private String autor;
    private String nume;
    private int numarPagini;

    /**
     * Book constructor
     * @param autor este de tip String si serveste pentru numele autorilor
     * @param nume este de tip String si serveste pentru numele cartilor
     * @param numarPagini este de tip int si serveste pentru numarul de pagini al cartilor
     */

    Book(String autor, String nume, int numarPagini){
        this.autor = autor;
        this.nume = nume;
        this.numarPagini = numarPagini;
    }

    /**
     * Metoda getter care
     * @return autorul cartilor sub forma de String
     */

    String getAutor() {
        return autor;
    }

    /**
     * Metoda getter care
     * @return numele cartilor sub forma de String
     */

    String getNume() {
        return nume;
    }

    /**
     * Metoda getter care
     * @return  numarul de pagini al cartilor sub forma de int
     */

    int getNumarPagini() {
        return numarPagini;
    }

    /**
     * Metoda suprascrisa din clasa Object care
     * @return numele si numarul de pagini al unei carti sub forma de String
     */

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                "nume='" + nume + '\'' +
                ", numarPagini=" + numarPagini +
                '}';
    }
}