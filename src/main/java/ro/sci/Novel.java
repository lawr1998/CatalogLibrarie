package ro.sci;

public class Novel extends Book {

    private String tip;

    /**
     * Novel constructor
     * @param autor este mostenit de la clasa Book si este de tip String si serveste pentru numele autorilor
     * @param nume este mostenit de la clasa Book si este de tip String si serveste pentru numele nuvelelor
     * @param numarPagini este mostenit de la clasa Book este de tip int si serveste pentru numarul de pagini al nuvelelor
     * @param tip este de tip String, este specific clasei Novel si serveste pentru tipul nuvelelor
     */

    public Novel(String autor, String nume, int numarPagini, String tip){
        super(autor ,nume, numarPagini);
        this.tip = tip;
    }

    /**
     * Metoda suprascrisa din clasa Book care
     * @return autorul, numele, numarul de pagini si tipul nuvelei sub forma de string
     */

    @Override
    public String toString() {
        return "Novel{" +
                "autor='" + getAutor() + '\'' +
                "nume='" + getNume() + '\'' +
                "numarPagini='" + getNumarPagini() + '\'' +
                "tip='" + tip + '\'' +
                '}';
    }
}