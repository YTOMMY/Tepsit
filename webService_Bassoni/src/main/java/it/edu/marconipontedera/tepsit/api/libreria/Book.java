package it.edu.marconipontedera.tepsit.api.libreria;

import java.util.List;

public class Book {
	private long id;
	private String title;
	private String language;
	private List<Author> authors;
	
	public Book() {
		this(null, null, null);
	}
	
	public Book(String title, String language, List<Author> authors) {
		this(title, language, authors, -1);
	}
	
	public Book(String title, String language, List<Author> authors, long id) {
		this.id = id;
		this.title = title;
		this.language = language;
		this.authors = authors;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
