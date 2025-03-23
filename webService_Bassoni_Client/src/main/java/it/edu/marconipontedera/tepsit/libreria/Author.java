package it.edu.marconipontedera.tepsit.libreria;

public class Author {
	private long id;
	private String name;
	private String surname;
	
	public Author() {
		this(null, null);
	}
	
	public Author(String name, String surname) {
		this(name, surname, -1);
	}
	
	public Author(String name, String surname, int id) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}