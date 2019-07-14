package com.bookstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.security.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	private BookRepository bookrepository;
	
	public List<Book> findAllBook() {
		List<Book> var = bookrepository.findAll();
		return var;
	}

	
	public Book save(Book book) {
		bookrepository.save(book);
		return book;
	}

	
	public List<Book> blurrySearch(String title) {
		List<Book> bar= bookrepository.findByTitleContaining(title);
		return bar;
	}

	public Book findOneBook(Long id) {
		Optional<Book> var = bookrepository.findById(id);
		return var.get();
		
	}
	public void removeOne(Long Id) {
		
		bookrepository.deleteById(Id);
	}

}
