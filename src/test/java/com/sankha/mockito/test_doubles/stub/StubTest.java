package com.sankha.mockito.test_doubles.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
