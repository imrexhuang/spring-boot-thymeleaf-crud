package example.java.spring.mvc.springbootthymeleafcrud.models.dao;

// https://ithelp.ithome.com.tw/articles/10191117

import org.springframework.data.repository.CrudRepository;

import example.java.spring.mvc.springbootthymeleafcrud.models.entity.Book;

public interface IBookDao extends CrudRepository<Book, Integer> {

}
