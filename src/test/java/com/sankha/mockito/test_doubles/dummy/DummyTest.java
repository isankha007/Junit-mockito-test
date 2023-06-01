package com.sankha.mockito.test_doubles.dummy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DummyTest {
    @Test
    public void demoDummy(){
        BookRepository bookRepository=new FakeBookRepository();
        EmailService emailService=new DummyEmailService();
        BookService bookService=new BookService(bookRepository,emailService);
        bookService.addBook(new Book("1234","Mockito book",230, LocalDate.now()));
        bookService.addBook(new Book("2345","Java book",700, LocalDate.now()));

        Assertions.assertEquals(2, bookService.findNumberOfBook());
    }
}
