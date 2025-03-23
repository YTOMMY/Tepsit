package it.edu.marconipontedera.tepsit.api.libreria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Library {
	@JsonProperty
	List<Book> books;
	@JsonProperty
	long currentId;
	
	Path path;
	
	public Library() {
		this("");
	}
	
	public Library(String path) {
		books = new ArrayList<Book>();
		currentId = -1;
		if(path != "") {
			this.path = Paths.get(path);
		}
		else {
			this.path = null;
		}
	}
	
	public static Library getFromFile(String path) {
		String json;
		try {
			json = new String(Files.readAllBytes(Paths.get(path)));
			System.out.println("[library] file trovato");
			ObjectMapper mapper = new ObjectMapper();
			Library library = mapper.readValue(json, Library.class);
			System.out.println("[library] Library inizializzata con successo");
			if(library.isEmpty()) {
				System.out.println("[library] libreria vuota");
			} else {
				System.out.println("[library] libreria riempita");
			}
			library.setPath(path);
			return library;
		} catch (IOException e) {
			System.out.println("[library] inizializzazione Library non riuscita");
			return new Library(path);
		}
	}

	public synchronized void save() {
		String json;
    	try {
        	ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return;
		}
    	try {
			Files.write(path, json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void setPath(String path) {
		this.path = Paths.get(path);
	}
	
	@JsonIgnore
	public synchronized String getPath() {
		return path.toString();
	}
	
	private synchronized long nextId() {
		while(exists(++currentId));
		return currentId;
	}
	

	@JsonIgnore
	public synchronized boolean isEmpty() {
		return books.isEmpty();
	}
	
	public synchronized boolean exists(long id) {
		if(id < 0) {
			return false;
		}
		for(Book book : books) {
			if(book.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public synchronized Book get(long id) {
		if(id < 0) {
			return null;
		}
		for(Book book : books) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}

	@JsonIgnore
	public synchronized List<Book> getAll() {
		return books;
	}
	
 	public synchronized long add(Book book) {
		if(exists(book.getId())) {
			return -1;
		}
		if(book.getId() < 0) {
			book.setId(nextId());
		}
		books.add(book);
		return book.getId();
	}
	
	public synchronized boolean remove(long id) {
		if(id < 0) {
			return false;
		}
		for(Book book : books) {
			if(book.getId() == id) {
				books.remove(book);
				return true;
			}
		}
		return false;
	}
	
	public synchronized boolean update(long id, Book book) {
		if (!exists(id)) {
			return false;
		}
		if (book.getId() < 0) {
			book.setId(id);
		}
		else if (book.getId() != id && exists(book.getId())) {
			return false;
		}
		remove(id);
		add(book);
		return true;
	}
}
