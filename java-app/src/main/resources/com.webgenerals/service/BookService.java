package com.webgenerals.service;

import com.webgenerals.dto.Book;
import java.util.Collection;

public interface BookService {

  Collection<Book> getBooks();

  Book addBook(Book book);
}