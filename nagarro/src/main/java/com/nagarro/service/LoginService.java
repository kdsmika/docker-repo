package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.Author;
import com.nagarro.model.Book;

@Service
public class LoginService {
	@Autowired
	private RestService restService;

	public List<Author> fetchAuthor() {
		List<Author> authors = restService.fetchAuthor();
		return authors;
	}

	public Book addBook(Book book) {
		Book addedbook = restService.addBook(book);
		return addedbook;
	}

	public void updateBook(Book book, int id) {
		restService.updateBook(book, id);
	}

	public List<Book> fetchAllBooks() {
		List<Book> books = restService.fetchAllBooks();
		return books;
	}

	public Book fetchBookById(int id) {
		Book book = restService.fetchBookById(id);
		return book;
	}

	public void deleteBook(int id) {
		restService.deleteBook(id);
	}
}
