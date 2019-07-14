package com.bookstore.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bookstore.domain.security.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {

	@Autowired
	private BookService bookResource;
	@RequestMapping(value ="/add",method = RequestMethod.POST)
	public Book addBookPost(@RequestBody Book book) {
		bookResource.save(book);
	return book;
	}
	
	@RequestMapping(value = "/add/image",method = RequestMethod.POST)
	public Map<String, String> upload(@RequestParam("id") Long id,HttpServletRequest request , HttpServletResponse response) {
		
		@SuppressWarnings("unused")
		Book b = bookResource.findOneBook(id);
		
	try {
		MultipartHttpServletRequest multiHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> it = multiHttpServletRequest.getFileNames();
		MultipartFile multipartFile = multiHttpServletRequest.getFile(it.next());
		String fileName = id+".png";
		byte[] bytes = multipartFile.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("src/main/resources/static/image/book/book"+fileName));
		stream.write(bytes);
		stream.close();
		return Collections.singletonMap("upload is successful","ok working session");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		return Collections.singletonMap("upload is failed","ok working session");
	}
	}
	

	@RequestMapping(value = "/getbooklist",method = RequestMethod.GET)
	public List<Book> getBookList() {
		return bookResource.findAllBook();
		
	}
	
	@RequestMapping("/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return bookResource.findOneBook(id);
		
	}
	
}
