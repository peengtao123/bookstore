package org.crazyit.test.ctl;

import java.util.List;

import org.crazyit.test.entity.Book;
import org.crazyit.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/findall", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getBooks() {
		return bookService.findAll();
	}
	
	@RequestMapping(value={"/save"}, method=RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)  
	public void save(@RequestBody Book book) {
		bookService.save(book);
	}
}
