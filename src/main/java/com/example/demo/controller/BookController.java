package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public String book() {
        return "Books Endpoint";
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @GetMapping("/book/{_id}")
    public Optional<Book> getBook(@PathVariable String _id) {
        return this.bookRepository.findById(_id);
    }

//    @PatchMapping("/book/{_id}")
//    public Book updateBook(@PathVariable String _id, @RequestBody Book book ) {
//        Book updateBook = this.bookRepository.findById(_id).get();
//
//    }

    @DeleteMapping("/book")
    public void deleteById(@RequestParam String _id){
        this.bookRepository.deleteById(_id);
    }

}
