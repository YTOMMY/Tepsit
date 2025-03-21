package it.edu.marconipontedera.tepsit.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import it.edu.marconipontedera.tepsit.api.libreria.Author;
import it.edu.marconipontedera.tepsit.api.libreria.AuthorServices;
import it.edu.marconipontedera.tepsit.api.libreria.Book;
import it.edu.marconipontedera.tepsit.api.libreria.BookServices;
import it.edu.marconipontedera.tepsit.api.libreria.Library;

@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("it.edu.marconipontedera.tepsit.api.libreria");
        packages("it.edu.marconipontedera.tepsit.api.test");
        
        Library library = Library.getFromFile("data.json");
        BookServices.library = library;
        System.out.println("[INFO API] inizializzazione effettuata");
    }
}