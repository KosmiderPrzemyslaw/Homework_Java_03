package pl.kosmider.service;

import org.springframework.stereotype.Service;
import pl.kosmider.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();

        list.add(new Book(1L, "021378", "Bruce Eckel"));
        list.add(new Book(2L, "021378", "Anna Morgan"));
        list.add(new Book(3L, "021378", "Morgan Freeman"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book findBookById(long id) {
        Book book = null;

        for (Book b : list
        ) {
            long id1 = b.getId();
            if (id1 == id) {
                book = b;
            }
        }
        return book;
    }

    public void addBookToList(Book book) {
        this.list.add(book);
    }

    public void update(Book book) {
        Book book2 = list.stream().filter(book1 -> book1.getId() == (book.getId()))
                .findFirst()
                .get();
        book2.setAuthor(book.getAuthor());
        book2.setIsbn(book.getIsbn());
    }

    public void delete(Book book){
        this.list.remove(book);
    }
}
