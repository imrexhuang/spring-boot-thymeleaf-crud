package example.java.spring.mvc.springbootthymeleafcrud.models.service;

import java.util.List;

import example.java.spring.mvc.springbootthymeleafcrud.models.entity.Book;

public interface IBookService {
	
	public List<Book> findAll();
	
	public void saveBook(Book book);
	
	public Book findByBookid(Integer bookid);
	
	public void deleteBook(Book book);

}
