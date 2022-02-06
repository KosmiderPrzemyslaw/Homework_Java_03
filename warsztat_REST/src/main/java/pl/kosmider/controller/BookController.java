package pl.kosmider.controller;

import org.springframework.web.bind.annotation.*;
import pl.kosmider.model.Book;
import pl.kosmider.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService memoryBookService;

    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @GetMapping("/helloBook")
    @ResponseBody
    public Book helloBook() {
        return new Book(1L, "Bruce ", "ja");
    }

    @RequestMapping("/allBooks")
    public List<Book> bookList() {
        return memoryBookService.getList();
    }

    @GetMapping("/findBookById/{id}")
    @ResponseBody
    private Book findBookById(@PathVariable long id) {
        return memoryBookService.findBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        memoryBookService.addBookToList(book);
    }

    @PutMapping
    public void modifyBook(@RequestBody Book book) {
        memoryBookService.update(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestBody Book book) {
        memoryBookService.delete(book);
    }
}
