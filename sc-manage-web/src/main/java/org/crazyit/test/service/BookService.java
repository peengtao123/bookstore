package org.crazyit.test.service;

import java.util.List;

import org.crazyit.test.entity.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "book", url = "http://localhost:9000/book")
public interface BookService {

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public void save(Book book);
	
	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	public List<Book> getBooks();
}
