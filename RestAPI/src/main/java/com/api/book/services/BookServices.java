package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Books;

@Component
public class BookServices {

	@Autowired
	private BookRepository bookRepository;

//	private static List<Books> list = new ArrayList<>();
//	static {
//		list.add(new Books(1, "Data Structure", "XYZ"));
//		list.add(new Books(2, "DAA", "WWW"));
//		list.add(new Books(3, "DBMS", "ABC"));
//	}

	// Get All Books
	public List<Books> getAllBooks() {
		List<Books> allBooks = (List<Books>) this.bookRepository.findAll();
		return allBooks;
	}

	// getting Single book by id
	public Books getSingleBook(int id) {
		Books res = null;
		try {
//		res = list.stream().filter(e -> e.getId() == id).findFirst().get();
			res = this.bookRepository.findById(id);
		} catch (Exception e2) {
		}
		return res;
	}

	// Adding the book
	public Books addBook(Books b) {
//		list.add(b);
		Books save = bookRepository.save(b);
		return save;
	}

	// Deleting the book
	public void deleteBook(int bookId) {
//		Books res = null;
//		res = list.stream().filter(e -> e.getId() == bookId).findFirst().get();
//		list.remove(res);

		bookRepository.deleteById(bookId);
	}

	// Update the book
	public void updateBook(Books book, int id) {
//		Books res = null;
//		res = list.stream().filter(e -> e.getId() == id).findFirst().get();
//		res.setAuthor(book.getAuthor());
//		res.setTitle(book.getTitle());
//		res.setId(book.getId());
//		return res;
		book.setId(id);
		bookRepository.save(book);
	}
}
