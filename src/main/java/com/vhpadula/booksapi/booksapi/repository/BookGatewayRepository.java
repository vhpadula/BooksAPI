package com.vhpadula.booksapi.booksapi.repository;

import com.vhpadula.booksapi.booksapi.model.Book;
import com.vhpadula.booksapi.booksapi.util.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookGatewayRepository {

    private final BookRepository bookRepo;
    private final BookMapper mapper;


    public List<Book> findAll() {
        List<BookEntity> entities = bookRepo.findAll();
        return entities.stream().map(mapper::toModel).toList();
    }

    public Optional<Book> find(Integer id) {
        Optional<BookEntity> entityOpt = bookRepo.findById(id);
        if (entityOpt.isEmpty())
            return Optional.empty();
        var book = mapper.toModel(entityOpt.get());
        return Optional.of(book);
    }

    public Book save(Book book) {
        BookEntity entity = mapper.toEntity(book);
        entity = bookRepo.save(entity);
        return mapper.toModel(entity);
    }

    public Optional<Book> findBookByTitle(String title) {
        Optional<BookEntity> entityOpt = bookRepo.findByTitle(title);
        if (entityOpt.isEmpty())
            return Optional.empty();
        return Optional.of(mapper.toModel(entityOpt.get()));
    }

    public Book update(Book book) {
        BookEntity entityForUpdate = bookRepo.findById(book.getId()).get();
        BookEntity entityFromUpdatedModel = mapper.toEntity(book);
        mapper.copyValues(entityFromUpdatedModel, entityForUpdate);
        entityForUpdate = bookRepo.save(entityForUpdate);
        return mapper.toModel(entityForUpdate);
    }

    public void delete(Integer id) {
        BookEntity entity = bookRepo.findById(id).get();
        bookRepo.delete(entity);
    }

    public List<String> findReviewsOfBook(Integer bookId) {
        BookEntity bookEntity = bookRepo.findById(bookId).get();
        List<String> reviews = bookEntity.getReviews();
        if (reviews == null)
            return new ArrayList<>();
        return reviews;
    }

    public String addReview(Integer bookId, String review) {
        BookEntity bookEntity = bookRepo.findById(bookId).get();
        if (bookEntity.getReviews() == null)
            bookEntity.setReviews(new ArrayList<>());
        bookEntity.getReviews().add(review);
        bookRepo.save(bookEntity);
        return review;
    }

}
