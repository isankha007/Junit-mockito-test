package com.sankha.mockito.test_doubles.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTest {

    @Test
    public void demoSpy(){
        BookRepositorySpy bookRepository=new BookRepositorySpy();
        BookService bookService=new BookService(bookRepository);

        Book mockitoBook = new Book("1234", "Mockito book", 500, LocalDate.now());
        Book javaBook = new Book("2345", "Java book", 400, LocalDate.now());
        bookService.addBook(mockitoBook);
        Assertions.assertEquals(0,bookRepository.timesCalled());
        bookService.addBook(javaBook);

        Assertions.assertEquals(1,bookRepository.timesCalled());
        Assertions.assertTrue(bookRepository.calledWith(javaBook));



    }
}
