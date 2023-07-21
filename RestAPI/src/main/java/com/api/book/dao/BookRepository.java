package com.api.book.dao;
import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Books;

public interface BookRepository extends CrudRepository<Books, Integer> {
	public Books findById(int id);
}
