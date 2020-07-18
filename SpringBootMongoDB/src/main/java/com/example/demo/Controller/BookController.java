package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.book;
import com.example.demo.repository.BookRepository;

@RestController("/books")
public class BookController {
	
	@Autowired
	private BookRepository BookRepository;
	
	@GetMapping("/findAllBooks")
	public List<book> getAllBooks()
	{
		return BookRepository.findAll();
	}
	
	@PostMapping("/addBooks")
	public String addAllBooks(@RequestBody book book)
	{
		 BookRepository.save(book);
		 return "book id";
	}
	
	@DeleteMapping("/deleteBooks/{id}")
	public String deleteBooks(@PathVariable int id)
	{
		 BookRepository.deleteById(id);
		 return "book id";
	}
	
	
	@GetMapping("/findBook/{id}")
	public String getAllBooksById(@PathVariable int id)
	{
		BookRepository.findById(id);
		return "book id";
	}
	

}
