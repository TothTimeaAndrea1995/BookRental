CREATE TABLE IF NOT EXISTS book (
    bookId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(255),
    title VARCHAR(255),
    publishedYear VARCHAR(4)
);

CREATE TABLE IF NOT EXISTS customer (
    customerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(255),
    first_name VARCHAR(255),
    bookCardNumber VARCHAR(255)
);

INSERT INTO book (book_id, author, title, publishedYear) VALUES
(1, 'George Orwell', '1984', '1949'),
(2, 'Kosztolányi Dezső', 'Édes Anna', '1926'),
(3, 'Robin Cook', 'Mutáció', '1989');