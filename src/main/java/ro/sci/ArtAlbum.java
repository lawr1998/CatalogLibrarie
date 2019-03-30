package ro.sci;

public class ArtAlbum extends Book{

    private String calitateHartie;

        /**
         * ArtAlbum constructor
         * @param autor este mostenit de la clasa Book si este de tip String si serveste pentru numele autorilor
         * @param nume este mostenit de la clasa Book si este de tip String si serveste pentru numele albumelor
         * @param numarPagini este mostenit de la clasa Book este de tip int si serveste pentru numarul de pagini al albumelor
         * @param calitateHartie este de tip String, este specific clasei ArtAlbum si serveste pentru calitatea hartiei albumelor
         */

        ArtAlbum(String autor, String nume, int numarPagini, String calitateHartie){
            super(autor, nume, numarPagini);
            this.calitateHartie = calitateHartie;
        }

        /**
         * Metoda suprascrisa din clasa Book care
         * @return autorul, numele, numarul de pagini si calitatea hartiei albumului sub forma de string
         */

        @Override
        public String toString() {
            return "ArtAlbum{" +
                    "autor='" + getAutor() + '\'' +
                    "nume='" + getNume() + '\'' +
                    "numarPagini='" + getNumarPagini() + '\'' +
                    "calitateHartie='" + calitateHartie + '\'' +
                    '}';
        }
    }