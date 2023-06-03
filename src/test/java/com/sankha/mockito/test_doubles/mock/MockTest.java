package com.sankha.mockito.test_doubles.mock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class MockTest {

    @Test
    public void demoSpy(){
        BookRepositoryMock bookRepository=new BookRepositoryMock();
        BookService bookService=new BookService(bookRepository);

        Book mockitoBook = new Book("1234", "Mockito book", 500, LocalDate.now());
        Book javaBook = new Book("2345", "Java book", 400, LocalDate.now());
        bookService.addBook(mockitoBook);
        bookService.addBook(javaBook);

        bookRepository.verify(javaBook,1);
    }

}
