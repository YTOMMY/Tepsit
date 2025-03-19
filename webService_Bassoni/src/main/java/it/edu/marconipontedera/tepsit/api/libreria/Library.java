package it.edu.marconipontedera.tepsit.api.libreria;

import java.util.ArrayList;
import java.util.List;

public class Library {
	List<Book> books;
	long currentId;
	
	public Library() {
		books = new ArrayList<Book>();
		currentId = 0;
	}
	
	private synchronized long nextId() {
		while(exists(++currentId));
		return currentId;
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
