package it.edu.marconipontedera.tepsit.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import it.edu.marconipontedera.tepsit.api.libreria.Book;
import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testGet() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/api").path("books").path("1");
		Response response = target.request().get();
		System.out.println("Response code: " + response.getStatus());
		Book book = response.readEntity(Book.class);
		System.out.println("Title: " + book.getTitle());
	}
}