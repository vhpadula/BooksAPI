package com.vhpadula.booksapi.booksapi.util;

import com.vhpadula.booksapi.booksapi.dto.BookRequest;
import com.vhpadula.booksapi.booksapi.dto.BookResponse;
import com.vhpadula.booksapi.booksapi.model.Book;
import com.vhpadula.booksapi.booksapi.repository.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Provides objects mapping,
 * acting as a abstraction layer of mapper provider
 */
@Component
@RequiredArgsConstructor
public class BookMapper {

    private final ModelMapper mapper;


    public Book toModel(BookEntity entity) {
        return mapper.map(entity, Book.class);
    }

    public BookEntity toEntity(Book book) {
        return mapper.map(book, BookEntity.class);
    }

    public BookEntity copyValues(BookEntity source, BookEntity destination) {
        mapper.map(source, destination);
        return destination;
    }

    public Book toModel(BookRequest request) {
        return mapper.map(request, Book.class);
    }

    public BookRequest toRequest(Book book) {
        return mapper.map(book, BookRequest.class);
    }

    public BookResponse toResponse(Book book) {
        return mapper.map(book, BookResponse.class);
    }

}
