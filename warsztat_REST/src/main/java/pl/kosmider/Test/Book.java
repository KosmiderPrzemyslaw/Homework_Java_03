package pl.kosmider.Test;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book>, Comparator<Book> {

    private Integer id;
    private String authorName;
    private String autorSurname;
    private String title;


    public Book() {
    }

    public Book(int id, String authorName, String autorSurname, String title) {
        this.id = id;
        this.authorName = authorName;
        this.autorSurname = autorSurname;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAutorSurname() {
        return autorSurname;
    }

    public void setAutorSurname(String autorSurname) {
        this.autorSurname = autorSurname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compare(Book book, Book t1) {
        return book.getAuthorName().compareTo(t1.getAuthorName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(authorName, book.authorName) &&
                Objects.equals(autorSurname, book.autorSurname) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName, autorSurname, title);
    }


    @Override
    public int compareTo(Book book) {
        return this.id - book.id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", autorSurname='" + autorSurname + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
