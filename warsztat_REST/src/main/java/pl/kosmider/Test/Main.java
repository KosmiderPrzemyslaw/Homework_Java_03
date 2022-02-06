package pl.kosmider.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = new Book(1, "Jan", "Brzechwa", "wiersze");
        Book book1 = new Book(4, "Adam", "Mickiewicz", "dziedy");
        Book book8 = new Book(6, "Adam", "Mickif", "dziedy");
        Book book2 = new Book(2, "Jacek", "Domagała", "o to");
        Book book3 = new Book(3, "Miłosz", "Czesław", "potop");
        Book book4 = new Book(5, "Zenon", "Martyniuk", "piosnki");
        Book book9 = new Book(7, "Adam", "Adamczyk", "piosnki");

        Book[] books = new Book[7];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        books[4] = book4;
        books[5] = book8;
        books[6] = book9;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }

        System.out.println("SORTED BOOKS BY ARRAYS SORT");
        Arrays.sort(books);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }

        List<Book> bookList = Arrays.asList(books);

        System.out.println("Sorted by author name");

        Comparator<Book> authorNameSorter = ((book5, t1) -> book5.getAuthorName().compareTo(t1.getAuthorName()));
        Comparator<Book> authorSurnameSorter = ((book6, t1) -> book6.getAutorSurname().compareTo(t1.getAutorSurname()));

        Comparator<Book> fullNameSorter =  authorNameSorter.thenComparing(authorSurnameSorter);


        Collections.sort(bookList, authorNameSorter);
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }


        System.out.println("Full name sorter");
        Collections.sort(bookList, fullNameSorter);

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }


    }
}
