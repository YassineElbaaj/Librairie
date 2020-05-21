package com.yassine.models;

import javax.persistence.*;

@Entity
@Table(name ="Book")
public class Book {
	
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name= "title")
	private String title;
	@ManyToOne
	@JoinColumn(name = "author")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "genre")
	private Genre genre;
	
	public Book() {
		
	}
	
	public Book(int id, String title, String summary, Author author, Genre genre) {
		
		this.id = id;
		
		this.title = title;
		
		this.summary = summary;
		
		this.author = author;
		
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", summary=" + summary + ", author=" + author.toString() + ", genre="
				+ genre.toString() + "]";
	}
}
