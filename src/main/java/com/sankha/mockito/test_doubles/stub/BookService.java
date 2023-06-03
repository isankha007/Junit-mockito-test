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
       return newBooks.stream().peek(book -> {
           int price = book.getPrice();
           price = price - (price*discountRate / 100);
           book.setPrice(price);
       }).collect(Collectors.toList());
       /*for (Book book:newBooks){
           int price = book.getPrice();
           int newPrice = price - (discountRate * price / 100);
           book.setPrice(newPrice);
       }*/

      /* newBooks.forEach(book -> {
           int price = book.getPrice();
           int newPrice = price - (discountRate*price / 100);
           book.setPrice(newPrice);
       });*/
      // return books;
   }

}
