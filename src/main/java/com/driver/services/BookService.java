package com.driver.services;

import com.driver.models.Book;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){

        List<Book> bookList = bookRepository2.findBooksByAuthor(author,available);//find the elements of the list by yourself
        List<Book> books = new ArrayList<>();
        for(Book book : bookList){
            if(book.getGenre().toString()==genre)
                books.add(book);
        }
        return books;
    }
}
