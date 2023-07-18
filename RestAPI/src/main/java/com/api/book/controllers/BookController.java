package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.entities.Books;
import com.api.book.services.BookServices;

@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;

//	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	@GetMapping("/books")
	public List<Books> getBooks() {
		return this.bookServices.getAllBooks();

//		Books book = new Books();
//		book.setAuthor("RamDas");
//		book.setId(111);
//		book.setTitle("Jamuna");

//		return book;
	}

	@GetMapping("/books/{id}")
	public Books getSingleBook(@PathVariable("id") int id) {
		return this.bookServices.getSingleBook(id);
	}
}
