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
		books = new ArrayList<Book>();
		currentId = -1;
	}
	
	public static Library getFromFile(String path) {
		String json;
		try {
			json = new String(Files.readAllBytes(Paths.get(path)));
			ObjectMapper mapper = new ObjectMapper();
			Library library = mapper.readValue(json, Library.class);
			return library;
		} catch (IOException e) {
			return null;
		}
	}

	public void save(String path) {
		String json;
    	try {
        	ObjectMapper mapper = new ObjectMapper();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return;
		}
    	try {
			Files.write(Paths.get(path), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized long nextId() {
		while(exists(++currentId));
		return currentId;
	}
	
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
