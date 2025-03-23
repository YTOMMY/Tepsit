package it.edu.marconipontedera.tepsit.api.libreria;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("books/{book_id}/authors")
public class AuthorServices {	
	@GET
	public List<Author> list(@PathParam("book_id") long bookId) {
		return new BookServices().get(bookId).getAuthors();
	}
}