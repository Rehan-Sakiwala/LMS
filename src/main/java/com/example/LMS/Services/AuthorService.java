package com.example.LMS.Services;

import com.example.LMS.DTOs.AuthorEntryDto;
import com.example.LMS.Models.Author;
import com.example.LMS.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){
        //Converting authorEntity to author
        Author author=new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRatings(authorEntryDto.getRating());

        authorRepository.save(author);
        return "Author added :-)";
    }
}
