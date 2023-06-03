package com.sankha.mockito.test_doubles.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StubTest {
    @Test
    public void demoStub(){
        BookRepository bookRepository=new BookReposotoryStub();
        BookService bookService=new BookService(bookRepository);
        List<Book> newBookWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7);
       newBookWithAppliedDiscount.forEach(book -> System.out.println(book.getBookId()));
        Assertions.assertEquals(2,newBookWithAppliedDiscount.size());
        Assertions.assertEquals(450,newBookWithAppliedDiscount.get(1).getPrice());
        Assertions.assertEquals(360,newBookWithAppliedDiscount.get(0).getPrice());

    }

    @Test
    public void demoStubWithMockito(){
        BookRepository bookRepository=mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);

        Book mockitoBook = new Book("1234", "Mockito book", 500, LocalDate.now());
        Book javaBook = new Book("2345", "Java book", 400, LocalDate.now());

        List<Book> books=new ArrayList<>();
        books.add(mockitoBook);
        books.add(javaBook);
        when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> newBookWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7);
        newBookWithAppliedDiscount.forEach(book -> System.out.println(book.getBookId()));



        Assertions.assertEquals(2,newBookWithAppliedDiscount.size());
        Assertions.assertEquals(450,newBookWithAppliedDiscount.get(0).getPrice());
        Assertions.assertEquals(360,newBookWithAppliedDiscount.get(1).getPrice());

    }
}
