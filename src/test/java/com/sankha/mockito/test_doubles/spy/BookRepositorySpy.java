package com.sankha.mockito.test_doubles.spy;

public class BookRepositorySpy implements BookRepository {

    int savedCalled=0;
    Book lastAddedBook=null;
    @Override
    public void save(Book book) {
        savedCalled++;
        lastAddedBook=book;
    }

    public int timesCalled(){
        return savedCalled;
    }
    public boolean calledWith(Book book){
        return lastAddedBook.equals(book);
    }
}
