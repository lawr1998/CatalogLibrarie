import ro.sci.Book;
import ro.sci.Novel;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Test {

    private List<Book> listaCarti = new ArrayList<>();

    /**
     * Metoda care testeaza daca size-ul listei este 1 dupa stergerea unui element din lista
     */

    @org.junit.Test
    public void sizeOfTheListAfterRemovingAnElement(){

        listaCarti.add(new Novel("autor 1", "nume 1", 50, "tip 1"));
        listaCarti.add(new Novel("autor 2", "nume 2", 50, "tip 2"));
        listaCarti.remove(0);
        assertEquals(1,listaCarti.size());
    }
}