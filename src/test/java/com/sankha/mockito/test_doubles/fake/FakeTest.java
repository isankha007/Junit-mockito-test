package com.sankha.mockito.test_doubles.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FakeTest {



   //

   @Test
    public void testFake(){
        BookRepository bookRepository=new FakeBookRepository();
        BookService bookService=new BookService(bookRepository);
        bookService.addBook(new Book("1234","Mockito book",230, LocalDate.now()));
        bookService.addBook(new Book("2345","Java book",700, LocalDate.now()));

        Assertions.assertEquals(2, bookService.findNumberOfBook());

    }


    @Test
    public void testFakeWithMockito(){
       BookRepository bookRepository= mock(BookRepository.class);
       BookService bookService=new BookService(bookRepository);
        Book mockitoBook = new Book("1234", "Mockito book", 500, LocalDate.now());
        Book javaBook = new Book("2345", "Java book", 400, LocalDate.now());

        Collection<Book> books=new ArrayList<>();
        books.add(mockitoBook);
        books.add(javaBook);

        when(bookRepository.findAll()).thenReturn(books);

        Assertions.assertEquals(2, bookService.findNumberOfBook());

   }
}
