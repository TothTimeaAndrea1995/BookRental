package hu.progkorny.book_rent_app.config;

import hu.progkorny.book_rent_app.repository.bookRepository;
import hu.progkorny.book_rent_app.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class bookConfig {

    @Autowired
        private bookRepository bookRepository;
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Books getBooksById(int bookId){
        Optional<Books> optionalBook = bookRepository.findBooks(bookId);
        return optionalBook.get();
    }
}
