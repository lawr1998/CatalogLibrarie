package ro.sci;

import java.io.FileNotFoundException;

public class OpenFileException extends FileNotFoundException {

    /**
     * Metoda care
     * @return un text sub forma de string
     */

    public String getMessage(){
        return "Fisierul nu se poate deschide ! ! !";
    }
}