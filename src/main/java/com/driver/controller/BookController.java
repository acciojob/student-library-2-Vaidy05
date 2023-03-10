package com.driver.controller;

import com.driver.models.Book;
import com.driver.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add required annotations
@Controller
@RequestMapping("/book")
public class BookController {


    //Write createBook API with required annotations
    @Autowired
    BookService bookService;
    //Add required annotations
    @PostMapping("/add_book")
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<>("Book is added successfully", HttpStatus.CREATED);
    }


    @GetMapping("/get_books")
    public ResponseEntity getBooks(@RequestParam(value = "genre", required = false) String genre,
                                   @RequestParam(value = "available", required = false, defaultValue = "false") boolean available,
                                   @RequestParam(value = "author", required = false) String author){

        List<Book> bookList = bookService.getBooks(genre,available,author); //find the elements of the list by yourself

        return new ResponseEntity<>(bookList, HttpStatus.OK);

    }
}
