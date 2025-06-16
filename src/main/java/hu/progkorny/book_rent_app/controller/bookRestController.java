package hu.progkorny.book_rent_app.controller;

import hu.progkorny.book_rent_app.repository.bookRepository;
import hu.progkorny.book_rent_app.model.Books;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestConroller
@RequestMapping("*/api/books")
public class bookRestController {

    private final bookRepository bookRepository;
    public bookRestController(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }    

    @GetMapping("/book_list")
    public ResponseEntity<List<Books>> getBooks() {
        List<Book> books = bookRepository.findAll(); // Lekérjük az összes könyvet a repository-ból
        return ResponseEntity.ok(books); // Visszatérünk a könyvekkel 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBooks@PathVariable Long id) {
        Books book = bookRepository.findBook(id); // Lekérjük a könyvet az adatbázisból
        return ResponseEntity.ok(book); // Visszatérünk a könyvvel
    }

    @PostMapping("/create")
    public ResponseEntity<Books> createBook(@RequestBody SimpleBooks simpleBook) {
        Books book = bookRepository.saveBook(simpleBook); // Könyv mentése az adatbázisba
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook); // Visszatérünk a létrehozott könyvvel
    }
}
