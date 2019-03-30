package ro.sci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

/**
 * Un console application care este capabil
 * sa stocheze, sa afiseze, sa stearga obiecte(carti), dintr-un Array, ArrayList, HashMap si un HashSet
 * sa deschida, sa citeasca, sa afiseaze niste date predefinite dintr-un fisier de tip .txt, sa inchida fisierul de tip .txt
 * Cartile, nuvele, albumele au niste parametrii comuni, dar nuvelele au un paramentru propriu, la fel si albumele
 * Aplicatia are o clasa Test care va testa daca size-ul unei liste va fi 1 dupa stergerea unui element din lista
 *
 *
 * @author Lorincz Marius Laurentiu
 * @version 1
 * @since 2019-03-27
 */

public class Main {

    public static void main(String[] args) throws OpenFileException {

        final Logger log = LoggerFactory.getLogger(Main.class);
        Interface operatie = new Operations();

        log.info("Ai deschis aplicatia CatalogLibrarie");

        Scanner scanner = new Scanner(System.in);
        log.info("Operatii disponibile :\n1.Adauga nuvele intr-un Array; sterge nuvele din Array\n2.Adauga nuvele, albume intr-un ArrayList; sterge nuvele, albume din ArrayList\n3.Adauga nuvele, albume intr-un HashMap; sterge nuvele, albume din HashMap\n4.Adauga nuvele, albume intr-un HashSet; sterge nuvele, albume din HashSet\n5.Deschide fisierul Books.txt, citeste si afiseaza datele din fisierul Books.txt, inchide fisierul Books.txt");
        log.info("Tasteaza numarul operatiei pe care vrei sa o efectuezi : ");
        int alegeOperatie = scanner.nextInt();

        switch(alegeOperatie){

            case 1 :
                log.info("Ai ales operatia 1 ");
                operatie.novelsWithArray();
                break;

            case 2 :
                log.info("Ai ales operatia 2 ");
                operatie.novelsAndArtAlbumsWithArrayList();
                break;

            case 3 :
                log.info("Ai ales operatia 3 ");
                operatie.novelsAndArtAlbumsWithHashMap();
                break;

            case 4 :
                log.info("Ai ales operatia 4 ");
                operatie.novelsAndArtAlbumsWithHashSet();
                break;

            case 5 :
                log.info("Ai ales operatia 5 ");
                operatie.openFile();
                operatie.readFile();
                operatie.closeFile();
                break;

            default :
                log.warn("Aceasta operatie nu poate sa fie efectuata");
                break;
        }
    }
}