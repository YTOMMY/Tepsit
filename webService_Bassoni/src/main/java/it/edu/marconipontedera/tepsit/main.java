package it.edu.marconipontedera.tepsit;

import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;

import it.edu.marconipontedera.tepsit.api.libreria.AuthorServices;
import it.edu.marconipontedera.tepsit.api.libreria.BookServices;
import it.edu.marconipontedera.tepsit.api.libreria.Library;

public class main implements ContainerLifecycleListener {
	public void onStartup(Container container) {
		Library library = new Library();
		AuthorServices.library = library;
		BookServices.library = library;
	}

	public void onReload(Container container) {
		
	}

	public void onShutdown(Container container) {
		
	}
}
