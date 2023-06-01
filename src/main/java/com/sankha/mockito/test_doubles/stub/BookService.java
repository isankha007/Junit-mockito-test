package com.sankha.mockito.test_doubles.stub;


import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   public List<Book> getNewBookWithAppliedDiscount(int discountRate,int days){
       List<Book> newBooks= bookRepository.findNewBooks(days);
       List<Book> books = newBooks.stream().map(book -> {
           int price = book.getPrice();
           price = price - (price * discountRate / 100);
           book.setPrice(price);
           return book;
       }).collect(Collectors.toList());
       return books;
   }

}
