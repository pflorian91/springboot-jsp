package com.webgenerals.service.impl;

import com.webgenerals.dto.Book;
import com.webgenerals.exception.DuplicateBookException;
import com.webgenerals.repository.BookRepository;
import com.webgenerals.repository.model.BookData;
import com.webgenerals.service.BookService;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  private static Book convertBookData(BookData bookData) {
    return new Book(bookData.getIsbn(), bookData.getName(), bookData.getAuthor());
  }

  private static BookData convertBook(Book book) {
    return new BookData(book.getIsbn(), book.getName(), book.getAuthor());
  }

  @Override
  public Collection<Book> getBooks() {
    return bookRepository.findAll()
        .stream()
        .map(BookServiceImpl::convertBookData)
        .collect(Collectors.toList());
  }

  @Override
  public Book addBook(Book book) {
    final Optional<BookData> existingBook = bookRepository.findById(book.getIsbn());
    if (existingBook.isPresent()) {
      throw new DuplicateBookException(book);
    }

    final BookData savedBook = bookRepository.add(convertBook(book));
    return convertBookData(savedBook);
  }
}
