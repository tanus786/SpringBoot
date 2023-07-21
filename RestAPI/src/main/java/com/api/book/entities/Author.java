package com.api.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String fname;
	private String lname;
	private String language;
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Books books;

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int id) {
		this.aid = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Author(int id, String fname, String lname, String language) {
		super();
		this.aid = id;
		this.fname = fname;
		this.lname = lname;
		this.language = language;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", fname=" + fname + ", lname=" + lname + ", language=" + language + "]";
	}

}
