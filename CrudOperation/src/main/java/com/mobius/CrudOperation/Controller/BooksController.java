package com.mobius.CrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobius.CrudOperation.Model.Books;
import com.mobius.CrudOperation.Service.BooksService;

@RestController
public class BooksController 
{
	@Autowired
	BooksService booksService;
	
	@GetMapping("/book")
	private List<Books> getAllBooks(){
		return booksService.getAllBooks();
	}

	
    @GetMapping("/book/{bookid}")
	private Books getBooks(@PathVariable("bookid") int bookid)
	{
		return booksService.getBooksById(bookid);
	}
    
    @PostMapping("/books")
    private int saveBook(@RequestBody Books books) {
	 booksService.saveOrUpdate(books);
	 return books.getBookid();
}
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid)
    {
    	booksService.delete(bookid);
    }
    @PutMapping("/books")
    private Books update(@RequestBody Books books)
    {
    	booksService.saveOrUpdate(books);
    	return books;
    }
}
