package com.nagarro.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.model.Author;
import com.nagarro.model.Book;
import com.nagarro.service.LoginService;

@Controller
public class AdminController {

	org.slf4j.Logger logger  = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private LoginService loginService;

	@GetMapping("/")
	public String showLogIn(Model model) {
		List<Book> books = loginService.fetchAllBooks();
		model.addAttribute("books", books);
		return "home";
	}

	@GetMapping("/addBook")
	public String showAddBook(Model model) {
		List<Author> authors = loginService.fetchAuthor();
		model.addAttribute("authors", authors);
		Book book =new Book();
		model.addAttribute("book",book);

		return "add";
	}

	@GetMapping("/add")
	public String showAdd() {
		return "add";
	}
	
	@PostMapping("/add")
	public String addbooks(@RequestParam("bookId") int id, @RequestParam("bookName") String name,
			@RequestParam("author") String author, @RequestParam("addedOn") String date) {
		try {
	        logger.info("Saving new book into database ,:: bookId"  + id + " bookName" + name + " Author Name: "
	        		+ author + "addedOn: " + date);

			System.out.println();
			Book book = new Book();
			book.setBookId(id);
			book.setBookName(name);
			book.setTemp_authName(author);
			book.setAddedOn(date);
			Book bookAdded = loginService.addBook(book);
			System.out.println(bookAdded);
			return "redirect:/home";

		} catch (Exception e) {
			logger.info("Saving new book into database error "+ e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/addBook";
	}

	@GetMapping("/home")
	public String goHome(Model model) {
		List<Book> books = loginService.fetchAllBooks();
		model.addAttribute("books", books);
		return "home";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Book book = loginService.fetchBookById(id);
		List<Author> authors = loginService.fetchAuthor();
		model.addAttribute("authors", authors);
		model.addAttribute("book", book);
		return "edit";
	}

	@PostMapping("/update")
	public String updateBook(@RequestParam("bookId") int id, @RequestParam("bookName") String name,
			@RequestParam("author") String author, Model model) {
		try {
			logger.info("Updating exiting book into database ,:: bookId"  + id + " bookName" + name 
					+ " Author Name: " + author);

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
          	String date= dateFormat.format(new Date());
          	
			System.out.println(id + " " + name + " " + author + " " + date);
			Book book = new Book();
			book.setBookId(id);
			book.setBookName(name);
			book.setTemp_authName(author);
			book.setAddedOn(date);
			loginService.updateBook(book, id);
			return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		logger.info("Removing exiting book into database ,:: bookId"  + id );
		loginService.deleteBook(id);
		return "redirect:/home";
	}
}
