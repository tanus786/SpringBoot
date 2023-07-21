package com.api.book.entities; 

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Books(int id, String title, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", author=" + author + "]";
	}

}
