package com.bookstore.service;

import java.util.List;

import com.bookstore.domain.security.Book;

public interface BookService {

	List<Book> findAllBook();
	Book findOneBook(Long id);
	Book save(Book book);
	
	List<Book> blurrySearch(String title);
	
	void removeOne(Long Id);
}
