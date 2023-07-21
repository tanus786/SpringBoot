package com.api.book.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.entities.Books;
import com.api.book.services.BookServices;

@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;

//	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getBooks() {
		List<Books> list = this.bookServices.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);

//		Books book = new Books();
//		book.setAuthor("RamDas");
//		book.setId(111);
//		book.setTitle("Jamuna");

//		return book;
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getSingleBook(@PathVariable("id") int id) {
		Books B = this.bookServices.getSingleBook(id);
		if (B == null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(B));
	}

	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		Books b = null;
		try {
			b = this.bookServices.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Object> deleteBook(@PathVariable("bookId") int id) {
		try {
			this.bookServices.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/books/{id}")
	public void updateBook(@RequestBody Books book, @PathVariable("id") int id) {
		try {
			this.bookServices.updateBook(book, id);
//			return ResponseEntity.ok().body(b);
		} catch (Exception e) {
			// TODO: handle exception
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	} 

}
