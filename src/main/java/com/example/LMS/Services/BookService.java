package com.example.LMS.Services;

import com.example.LMS.DTOs.BookRequestDto;
import com.example.LMS.Models.Author;
import com.example.LMS.Models.Book;
import com.example.LMS.Repositories.AuthorRepository;
import com.example.LMS.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){
        Book book=new Book();
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);

        int authorId = bookRequestDto.getAuthorId();
        Author author=authorRepository.findById(authorId).get();
        book.setAuthor(author);

        //Update in Author table
        List<Book> currentBooks=author.getBooksWritten();
        currentBooks.add(book);

        authorRepository.save(author);
        return "Book added";
    }
}
