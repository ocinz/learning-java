package tech.kokage.simpleapi.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "Inmujin", "Nakajima Gara"),
            new Book(2L, "Imamudin", "Nakajima Gula"),
            new Book(3L, "Elizabeth", "Nakajima Satou")
    ));

    public List<Book> getBooks(){
        return books;
    }

    public Optional<Book> getBook(Long id){
        return books.stream()
                .filter((book)->book.id()
                        .equals(id))
                .findFirst();
    }

    public Book addBook(Book book){
        books.add(book);
        return book;
    }
}
