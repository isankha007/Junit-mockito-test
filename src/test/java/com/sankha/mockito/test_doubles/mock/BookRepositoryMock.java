package com.sankha.mockito.test_doubles.mock;


import static org.junit.Assert.assertEquals;

public class BookRepositoryMock implements BookRepository {

    int savedCalled=0;
    Book lastAddedBook=null;
    @Override
    public void save(Book book) {
        savedCalled++;
        lastAddedBook=book;
    }

    public void verify(Book book,int times){
        assertEquals(times,savedCalled);
        assertEquals(book,lastAddedBook);
    }

  }
