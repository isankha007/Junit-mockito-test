package com.sankha.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.*;

public class BookReposotoryStub implements BookRepository {

    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> books=new LinkedList<>();
        Book book1=new Book("1234","Mockito book",500, LocalDate.now());
        Book book2=new Book("1235","java book",400, LocalDate.now());
        books.add(book2);
        books.add(book1);
        return books;
    }
}
