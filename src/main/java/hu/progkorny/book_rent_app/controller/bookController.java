package hu.progkorny.book_rent_app.controller;

import hu.progkorny.book_rent_app.repository.bookRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/books") //Ezt használjuk a böngészőben!
public class bookController {

    private final bookRepository bookRepository;

    public bookController(bookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book_list") // Ez a metódus fog válaszolni a /books/book_list URL-re
    public String getBooks(Model model) {
        List<Books> allBooks = bookRepository.findAll(); // Lekérjük az összes könyvet a repository-ból
        model.addAttribbute("books", allBooks); // A model-be hozzáadjuk a könyveket

        return "books/book_list.html"; // A HTML fájl elérési útja a resources/templates mappában
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(Model model, @PathVariable Long id) {
        bookRepository.deleteById(id); // Töröljük a könyvet az adatbázisból

        List<Books> allBooks = bookRepository.findAll(); // Lekérjük az összes könyvet a repository-ból
        model.addAttribbute("books", allBooks); // A model-be hozzáadjuk a könyveket

        return "books/book_list"; // Visszatérünk a könyvlistához
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id) {
        Books book = bookRepository.findProduct(id); // Lekérjük a könyvet az adatbázisból
        model.addAttribute("book", book); // A model-be hozzáadjuk a könyvet

        return "books/edit_book"; // Visszatérünk az edit_book.html nézethez
    }

    @PostMapping("/update")
    public String updateBook(Model model, @ModelAttribute("book") SimpleBooks book) {
        Book updatedBook = productRepository.updateProduct(book.id(), book); // Lekérjük a könyvet az adatbázisból
        model.addAttribute("book", updatedBook); // A model-be hozzáadjuk a könyvet

        return "redirect:/books/book_list"; // Visszairányítjuk a könyvlistához
    }

}
