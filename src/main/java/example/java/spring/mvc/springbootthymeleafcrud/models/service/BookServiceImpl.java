package example.java.spring.mvc.springbootthymeleafcrud.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import example.java.spring.mvc.springbootthymeleafcrud.models.dao.IBookDao;
import example.java.spring.mvc.springbootthymeleafcrud.models.entity.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return (List<Book>) bookDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Book findByBookid(Integer bookid) {
		Optional<Book> optionalBook = bookDao.findById(bookid);
		return optionalBook.isPresent() ? optionalBook.get() : null;
	}

	@Override
	@Transactional
	public void saveBook(Book book) {
		bookDao.save(book);
	}

	@Override
	@Transactional
	public void deleteBook(Book book) {
		bookDao.delete(book);
	}

}
