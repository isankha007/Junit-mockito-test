package com.sankha.mockito.test_doubles.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;



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
}
