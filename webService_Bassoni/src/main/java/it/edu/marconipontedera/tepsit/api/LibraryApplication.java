package it.edu.marconipontedera.tepsit.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("it.edu.marconipontedera.tepsit.api.libreria");
        packages("it.edu.marconipontedera.tepsit.api.test");
    }
}