package org.crazyit.test.dao;



import org.crazyit.test.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {

	
}
