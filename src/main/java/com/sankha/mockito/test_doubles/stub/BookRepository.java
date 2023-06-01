package com.sankha.mockito.test_doubles.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {
    void save(Book book);
    Collection<Book> findAll();

    List<Book> findNewBooks(int days);
}
