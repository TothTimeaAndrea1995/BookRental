package hu.progkorny.book_rent_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class book {

@Id private int bookId;
private String author;
private String title;
private int publishedYear;

public book() {
    // Default constructor
}
