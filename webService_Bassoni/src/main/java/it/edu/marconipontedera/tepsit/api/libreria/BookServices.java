package it.edu.marconipontedera.tepsit.api.libreria;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("books")
public class BookServices {
	
	public static Library library;
	
	@GET
	public List<Book> list() {
		return library.getAll();
	}
	
	@GET
	@Path("{id}")
	public Book get(@PathParam("{id}") long id) {
		return library.get(id);
	}
	
	@POST
	public Response add(Book book) throws URISyntaxException {
		long newId = library.add(book);
		return Response.created(new URI("api/books/" + newId)).build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("{id}") long id, Book book) {
		library.update(id, book);
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("{id}") long id) {
		return Response.noContent().build();
	}
}
