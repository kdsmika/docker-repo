package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.model.Author;
import com.nagarro.model.Book;

@Service
public class RestService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${backend.url}") // Injecting the value of backend.url from application.properties
	private String backendUrl;

	
	@SuppressWarnings("unchecked")
	public List<Author> fetchAuthor() {
		List<Author> authors = restTemplate.getForObject(backendUrl+"authors", List.class);
		return authors;
	}

	public Book addBook(Book book) {
		Book addedbook = restTemplate.postForObject(backendUrl+"book", book, Book.class);
		return addedbook;
	}

	public void updateBook(Book book, int id) {
		restTemplate.put(backendUrl+"book/" + id, book, Book.class);
	}

	@SuppressWarnings("unchecked")
	public List<Book> fetchAllBooks() {
		List<Book> books = restTemplate.getForObject(backendUrl+"books", List.class);
		return books;
	}

	public Book fetchBookById(int id) {
		Book book = restTemplate.getForObject(backendUrl+"book/" + id, Book.class);
		return book;
	}

	public void deleteBook(int id) {
		restTemplate.delete(backendUrl+"delete/" + id, Book.class);
	}
}
