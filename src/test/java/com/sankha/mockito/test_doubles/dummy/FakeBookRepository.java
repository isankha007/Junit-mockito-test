package com.sankha.mockito.test_doubles.dummy;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    Map<String, Book> bookStore=new HashMap<>();
    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }
}
