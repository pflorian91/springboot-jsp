package com.webgenerals.exception;

import com.webgenerals.dto.Book;
import lombok.Getter;

@Getter
public class DuplicateBookException extends RuntimeException {

  private final Book book;

  public DuplicateBookException(Book book) {
    this.book = book;
  }
}