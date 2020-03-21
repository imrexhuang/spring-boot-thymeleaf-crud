package example.java.spring.mvc.springbootthymeleafcrud.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import example.java.spring.mvc.springbootthymeleafcrud.models.entity.Book;
import example.java.spring.mvc.springbootthymeleafcrud.models.service.IBookService;

@Controller
@SessionAttributes("book")
public class BookController {

	@Autowired
	private IBookService bookService;

    
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Home");
		return "index";
	}

	@GetMapping("/books")
	public String list(Map<String, Object> model) {
		model.put("title", "Books List - BookController");
		model.put("books", bookService.findAll());
		return "booklist";
	}

	@GetMapping("/books/new")
	public String add(Map<String, Object> model) {
		Book book = new Book();
		model.put("title", "New Book - BookController");
		model.put("book", book);
		return "bookform";
	}

	@GetMapping("/books/edit/{bookid}")
	public String edit(@PathVariable(value = "bookid") Integer bookid, Map<String, Object> model, RedirectAttributes flash) {
		if (bookid <= 0) {
			flash.addFlashAttribute("error", "Book ID must be greater than zero.");
			return "redirect:/books";
		}

		Book book = bookService.findByBookid(bookid);
		if (book == null) {
			flash.addFlashAttribute("error", "Book must be a valid book.");
			return "redirect:/books";
		}
		model.put("title", "Edit Book - BookController");
		model.put("book", book);
		return "bookform";
	}

	@PostMapping("/books/save")
	public String save(@Valid Book book, BindingResult result, Map<String, Object> model, SessionStatus status,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			String title = book.getBookid() == null ? "New Book" : "Edit Book";
			model.put("title", title);
			return "bookform";
		}

		String message = book.getBookid() == null ? "Book added successfully." : "Book changed successfully.";
		bookService.saveBook(book);
		status.setComplete();
		flash.addFlashAttribute("success", message);
		return "redirect:/books";
	}

	@GetMapping("/books/delete/{bookid}")
	public String delete(@PathVariable(value = "bookid") Integer bookid, Map<String, Object> model, RedirectAttributes flash) {
		if (bookid <= 0) {
			flash.addFlashAttribute("error", "Book ID must be grater than zero.");
			return "redirect:/books";
		}

		Book book = bookService.findByBookid(bookid);
		if (book == null) {
			flash.addFlashAttribute("error", "Book must be a valid book.");
			return "redirect:/books";
		}
		bookService.deleteBook(book);
		flash.addFlashAttribute("success", "Book deleted successfully");
		return "redirect:/books";
	}
}
