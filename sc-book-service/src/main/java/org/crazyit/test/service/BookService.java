package org.crazyit.test.service;

import java.util.List;

import org.crazyit.test.dao.BookDao;
import org.crazyit.test.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;

	public List<Book> findAll() {
		List<Book> books = bookDao.findAll();
		return books;
	}
	
	public void save(Book book) {
		bookDao.save(book);
	}
}
