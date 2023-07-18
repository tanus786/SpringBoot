package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.entities.Books;

@Component
public class BookServices {

	private static List<Books> list = new ArrayList<>();
	static {
		list.add(new Books(1, "Data Structure", "XYZ"));
		list.add(new Books(2, "DAA", "WWW"));
		list.add(new Books(3, "DBMS", "ABC"));
	}

	// Get All Books
	public List<Books> getAllBooks() {
		return list;
	}
	//getting Single book by id
	public Books getSingleBook(int id) {
		Books res = null;
		res = list.stream().filter(e->e.getId() == id).findFirst().get();
		return res;
	}
}
