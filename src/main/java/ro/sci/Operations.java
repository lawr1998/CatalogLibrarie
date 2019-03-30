package ro.sci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Implementeaza metoda {@link #novelsWithArray()} care adauga cartie, sterge o carte din bookArray
 * Implementeaza metoda {@link #novelsAndArtAlbumsWithArrayList()} care adauga nuvele/albume, sterge nuvele/albume din listaCarti
 * Implementeaza metoda {@link #novelsAndArtAlbumsWithHashMap()} care adauga nuvele/albume, sterge nuvele/albume din mapB
 * Implementeaza metoda {@link #novelsAndArtAlbumsWithHashSet()} care adauga nuvele/albume, sterge nuvele/albume din setB
 * Implementeaza metoda {@link #openFile()} care deschide fisierul Books.txt
 * Implementeaza metoda {@link #readFile()} care citeste si afiseaza datele din fisierul Books.txt
 * Implementeaza metoda {@link #closeFile()} care inchide fisierul Books.txt
 */

public class Operations implements Interface {

    private final Logger log = LoggerFactory.getLogger(Operations.class);
    private Scanner x;
    private Book book = new Book("autor", "nume", 50);
    private List<Book> listaCarti = new ArrayList<>();
    private Book[] bookArray = new Book[5];
    private Map<Integer, Book> mapB = new HashMap<>();
    private Set<Book> setB = new HashSet<>();

    /**
     * Aplicatia te va intreba daca vrei sa introduci nuvele in bookArray
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci 5 obiecte de tip Novel in bookArray
     * Dupa ce ai introdus obiectele, aplicatia va lista obiectele introduse in bookArray, si size-ul lui bookArray
     * Aplicatia te va pune sa introduci indexul obiectului pe care vrei sa il stergi din Array
     * Dupa ce ai introdus indexul obiectului, aplicatia va sterge obiectul respectiv, va lista obiectele lui bookArray dupa stergerea obiectului si size-ul lui bookArray dupa stergerea obiectului
     */

    @Override
    public void novelsWithArray() {

        Scanner sc0 = new Scanner(System.in);
        log.info("Doresti sa introduci nuvele in Array da / nu ?");
        String quitValue0 = sc0.next();

        if (quitValue0.equals("da")) {

            IntStream.range(0, bookArray.length).forEachOrdered(i -> {
                bookArray[i] = book;
                Scanner scanner = new Scanner(System.in);
                log.info("Introdu autorul nuvelei : ");
                String autor = scanner.nextLine();
                log.info("Introdu numele nuvelei : ");
                String nume = scanner.nextLine();
                log.info("Introdu numarul de pagini al nuvelei : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introdu tipul nuvelei");
                String tip = scanner.nextLine();
                bookArray[i] = new Novel(autor, nume, numarPagini, tip);
                log.info("Ai adaugat obiectul : " + bookArray[i] + " in indexul " + i);
            });

            log.info("Ai generat urmatorul Array : ");
            Arrays.stream(bookArray).forEachOrdered(System.out::println);
            log.info("Dimensiunea Array-ului este : " + bookArray.length);

            Scanner sc1 = new Scanner(System.in);
            log.info("Introdu indexul nuvelei pe care vrei sa o stergi : ");
            int indexToRemove = sc1.nextInt();
            Book[] newArray = new Novel[bookArray.length - 1];
            IntStream.range(0, bookArray.length).forEachOrdered(i -> {
                if (i < indexToRemove) {
                    newArray[i] = bookArray[i];
                } else if (i > indexToRemove) {
                    newArray[i - 1] = bookArray[i];
                }
            });
            log.info("Obiectul cu indexul " + indexToRemove + " a fost sters din Array");
            log.info("Array-ul dupa stergere : ");
            Arrays.stream(newArray).forEachOrdered(System.out::println);
            log.info("Dimensiunea Array-ului este : " + newArray.length);
        }
    }

    /**
     * Aplicatia te va intreba daca vrei sa introduci nuvele/albume in listaCarti
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci obiecte de tip Novel si ArtAlbum in listaCarti
     * Dupa ce ai introdus un obiect de tip Novel si ArtAlbum aplicatia te va intreba daca vrei sa mai introduci obiecte in listaCarti
     * Dupa ce ai terminat de introdus obiectele, aplicatia va lista obiectele introduse in listaCarti
     * Aplicatia te va intreba daca vrei sa stergi obiecte de tip Novel si ArtAlbum din listaCarti
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci numele obiectului pe care vrei sa il stergi
     * Aplicatia te va intreba daca vrei sa mai stergi obiecte din listaCarti
     * Daca vei tasta nu, aplicatia va afisa obiectele din listaCarti dupa stergerea obiectului/obiectelor
     * Daca vei tasta da, aplicatia te va pune sa introduci numele obiectului pe care vrei sa il stergi
     */

    @Override
    public void novelsAndArtAlbumsWithArrayList() {

        Scanner sc0 = new Scanner(System.in);
        log.info("Doresti sa introduci nuvele/albume in ArrayList da / nu ?");
        String quitValue0 = sc0.next();

        if (quitValue0.equals("da")) {

            while (true) {

                Scanner scanner = new Scanner(System.in);
                log.info("Introdu autorul nuvelei : ");
                String autor = scanner.nextLine();
                log.info("Introdu numele nuvelei : ");
                String nume = scanner.nextLine();
                log.info("Introdu numarul de pagini al nuvelei : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introdu tipul nuvelei : ");
                String tip = scanner.nextLine();
                listaCarti.add(new Novel(autor, nume, numarPagini, tip));
                log.info("Doresti sa mai introduci nuvele da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }
            }

            while (true) {

                Scanner scanner = new Scanner(System.in);
                log.info("Introdu autorul albumului : ");
                String autor = scanner.nextLine();
                log.info("Introdu numele albumului : ");
                String nume = scanner.nextLine();
                log.info("Introdu numarul de pagini al albumului : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introdu calitatea hartiei albumului : ");
                String calitateHartie = scanner.nextLine();
                listaCarti.add(new ArtAlbum(autor, nume, numarPagini, calitateHartie));
                log.info("Doresti sa mai introduci albume da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }
            }

            log.info("Ai generat urmatorul ArrayList");
            listaCarti.forEach(book -> System.out.println(book.toString()));

            Scanner sc1 = new Scanner(System.in);
            log.info("Doresti sa stergi nuvele/albume din ArrayList da / nu ?");
            String quitValue1 = sc1.next();

                if (quitValue1.equals("da")) {

                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        log.info("Introdu numele nuvelei/albumului pe care vrei sa il stergi : ");
                        String removeAlbumByName = scanner.nextLine();
                        listaCarti.removeIf(stergeElement -> stergeElement.getNume().equals(removeAlbumByName));

                        log.info("Doresti sa mai stergi nuvele/albume din ArrayList da / nu ?");
                        String quitValue = scanner.next();

                        if (quitValue.equalsIgnoreCase("nu")) {
                            break;
                        }
                    }

                    log.info("ArrayList-ul dupa stergere :");
                    listaCarti.forEach(book -> System.out.println(book.toString()));
                }
            }
        }

    /**
     * Aplicatia te va intreba daca vrei sa introduci nuvele/albume in mapB
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci obiecte de tip Novel si ArtAlbum in mapB
     * Dupa ce ai introdus un obiect de tip Novel si ArtAlbum aplicatia te va intreba daca vrei sa mai introduci obiecte in mapB
     * Dupa ce ai terminat de introdus obiectele, aplicatia va lista obiectele introduse in mapB
     * Aplicatia te va intreba daca vrei sa stergi obiecte de tip Novel si ArtAlbum din mapB
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci key-ul obiectului pe care vrei sa il stergi
     * Aplicatia te va intreba daca vrei sa mai stergi obiecte din mapB
     * Daca vei tasta nu, aplicatia va afisa obiectele din mapB dupa stergerea obiectului/obiectelor
     * Daca vei tasta da, aplicatia te va pune sa introduci numele obiectului pe care vrei sa il stergi
     */

    @Override
    public void novelsAndArtAlbumsWithHashMap() {

        Scanner sc0 = new Scanner(System.in);
        log.info("Doresti sa introduci nuvele/albume in HashMap da / nu ?");
        String quitValue0 = sc0.next();

        if (quitValue0.equals("da")) {

            while (true) {
                Scanner scanner = new Scanner(System.in);
                log.info("Introduceti key-ul nuvelei : ");
                int key = scanner.nextInt();
                scanner.nextLine();
                log.info("Introduceti autorul nuvelei : ");
                String autor = scanner.nextLine();
                log.info("Introduceti numele nuvelei : ");
                String nume = scanner.nextLine();
                log.info("Introduceti numarul de pagini al nuvelei : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introduceti tipul nuvelei : ");
                String tip = scanner.nextLine();
                mapB.put(key, new Novel(autor, nume, numarPagini, tip));
                log.info("Doresti sa mai introduci nuvele in HashMap da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }

            }

            while (true) {
                Scanner scanner = new Scanner(System.in);
                log.info("Introduceti key-ul albumului : ");
                int key = scanner.nextInt();
                scanner.nextLine();
                log.info("Introduceti autorul albumului : ");
                String autor = scanner.nextLine();
                log.info("Introduceti numele albumului : ");
                String nume = scanner.nextLine();
                log.info("Introduceti numarul de pagini al albumului : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introduceti calitatea hartiei albumului : ");
                String calitateHartie = scanner.nextLine();
                mapB.put(key, new ArtAlbum(autor, nume, numarPagini, calitateHartie));
                log.info("Doresti sa mai introduci albume in HashMap da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }
            }

            log.info("Ai generat urmatorul HashMap");
            mapB.entrySet().stream().map(entry -> "Key-ul este : " + entry.getKey() + " - " + "Valoare este : " + entry.getValue()).forEach(System.out::println);

            Scanner sc1 = new Scanner(System.in);
            log.info("Doresti sa stergi nuvele/albume din HashMap da / nu ?");
            String quitValue1 = sc1.nextLine();

            if (quitValue1.equals("da")) {

                while (true) {

                    Scanner scanner = new Scanner(System.in);
                    log.info("Introdu key-ul nuvelei/albumului pe care vrei sa il stergi : ");
                    int key = scanner.nextInt();
                    mapB.keySet().removeIf(deleteNovel -> deleteNovel.equals(key));
                    log.info("Doresti sa mai stergi nuvele/albume din HashMap da / nu ?");
                    String quitValue = scanner.next();

                    if (quitValue.equalsIgnoreCase("nu")) {
                        break;
                    }
                }

                log.info("HashMap-ul dupa stergere : ");
                mapB.entrySet().stream().map(entry -> "Key-ul este : " + entry.getKey() + " - " + "Valoare este : " + entry.getValue()).forEach(System.out::println);
            }
        }
    }

    /**
     * Aplicatia te va intreba daca vrei sa introduci nuvele/albume in setB
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci obiecte de tip Novel si ArtAlbum in setB
     * Dupa ce ai introdus un obiect de tip Novel si ArtAlbum aplicatia te va intreba daca vrei sa mai introduci obiecte in setB
     * Dupa ce ai terminat de introdus obiectele, aplicatia va lista obiectele introduse in setB
     * Aplicatia te va intreba daca vrei sa stergi obiecte de tip Novel si ArtAlbum din setB
     * Daca vei tasta nu, aplicatia nu va executa nici o comanda
     * Daca vei tasta da, aplicatia te va pune sa introduci numele obiectului pe care vrei sa il stergi
     * Aplicatia te va intreba daca vrei sa mai stergi obiecte din setB
     * Daca vei tasta nu, aplicatia va afisa obiectele din setB dupa stergerea obiectului/obiectelor
     * Daca vei tasta da, aplicatia te va pune sa introduci numele obiectului pe care vrei sa il stergi
     */

    @Override
    public void novelsAndArtAlbumsWithHashSet() {

        Scanner sc0 = new Scanner(System.in);
        log.info("Doresti sa introduci nuvele/albume in HashSet da / nu ?");
        String quitValue0 = sc0.next();

        if (quitValue0.equals("da")) {

            while (true) {

                Scanner scanner = new Scanner(System.in);
                log.info("Introdu autorul nuvelei : ");
                String autor = scanner.nextLine();
                log.info("Introdu numele nuvelei : ");
                String nume = scanner.nextLine();
                log.info("Introdu numarul de pagini al nuvelei: ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introdu tipul nuvelei : ");
                String tip = scanner.nextLine();
                setB.add(new Novel(autor, nume, numarPagini, tip));
                log.info("Doresti sa mai introduci nuvele da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }
            }

            while (true) {

                Scanner scanner = new Scanner(System.in);
                log.info("Introdu autorul albumului : ");
                String autor = scanner.nextLine();
                log.info("Introdu numele albumului : ");
                String nume = scanner.nextLine();
                log.info("Introdu numarul de pagini al albumului : ");
                int numarPagini = scanner.nextInt();
                scanner.nextLine();
                log.info("Introdu calitatea hartiei albumului : ");
                String calitateHartie = scanner.nextLine();
                setB.add(new ArtAlbum(autor, nume, numarPagini, calitateHartie));
                log.info("Doresti sa mai introduci albume da / nu ?");
                String quitValue = scanner.next();
                if (quitValue.equalsIgnoreCase("nu")) {
                    break;
                }
            }

            log.info("Ai generat urmatorul HashSet : ");
            setB.stream().map(Book::toString).forEach(System.out::println);

            Scanner sc1 = new Scanner(System.in);
            log.info("Doresti sa stergi nuvele/albume din HashSet da / nu ?");
            String quitValue1 = sc1.next();

            if (quitValue1.equals("da")) {

                while (true) {

                    Scanner scanner = new Scanner(System.in);
                    log.info("Introdu numele nuvelei/albumului pe care vrei sa il stergi : ");
                    String removeAlbum = scanner.nextLine();
                    setB.removeIf(stergeElement -> stergeElement.getNume().equals(removeAlbum));
                    log.info("Doresti sa mai stergi nuvele/albume din HashSet da / nu ?");
                    String quitValue = scanner.next();
                    if (quitValue.equalsIgnoreCase("nu")) {
                        break;
                    }
                }

                log.info("HashSet-ul dupa stergere : ");
                setB.stream().map(Book::toString).forEach(System.out::println);
            }
        }
    }

    /**
     * Se va deschide fisierul Books.txt
     * Trebuie sa introduci path-ul corect altfel programul va afisa urmatorea propozitie
     * "Fisierul nu se poate deschide ! ! !"
     */

    @Override
    public void openFile() throws OpenFileException {

        log.info("Deschidere fisier Books.txt");
        try {
            x = new Scanner(new File("D:\\CatalogLibrarie\\src\\main\\java\\ro\\sci\\Books.txt"));
        } catch (FileNotFoundException e) {
            throw new OpenFileException();
        }
    }

    /**
     * Se citesc toate datele din fisier iar apoi sunt afisate in consola
     */

    @Override
    public void readFile() {

        log.info("Citire si afisare date din fisierul Book.txt");

        while (x.hasNext()) {

            String a = x.next();
            String b = x.next();
            String c = x.next();
            String d = x.next();
            String e = x.next();
            String f = x.next();
            String g = x.next();
            String h = x.next();
            String i = x.next();
            System.out.printf("%s %s %s %s %s %s %s %s %s \n", a, b, c, d, e, f, g, h, i);
        }
    }

    /**
     * Se inchide fisierul
     */

    @Override
    public void closeFile() {

        log.info("Inchidere fisier Books.txt");
        x.close();
    }
}