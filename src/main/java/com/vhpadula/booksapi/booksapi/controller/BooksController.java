package com.vhpadula.booksapi.booksapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vhpadula.booksapi.booksapi.dto.BookRequest;
import com.vhpadula.booksapi.booksapi.dto.BookResponse;
import com.vhpadula.booksapi.booksapi.dto.ReviewRequest;
import com.vhpadula.booksapi.booksapi.dto.ReviewResponse;
import com.vhpadula.booksapi.booksapi.service.BooksService;
import com.vhpadula.booksapi.booksapi.util.BookMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService service;
    private final BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        var books = service.findBooks();
        var booksResp = books.stream().map(bookMapper::toResponse).toList();
        return ResponseEntity.ok(booksResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable("id") Integer id) {
        var book = service.findBookById(id);
        var bookResp = bookMapper.toResponse(book);
        return ResponseEntity.ok(bookResp);
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody @Valid BookRequest request) {
        var book = bookMapper.toModel(request);
        book = service.createBook(book);
        var bookResp = bookMapper.toResponse(book);
        return ResponseEntity.created(URI.create(book.getId().toString())).body(bookResp);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Integer id, @RequestBody @Valid BookRequest request) {
        var book = bookMapper.toModel(request);
        book.setId(id);
        book = service.updateBook(book);
        var bookResp = bookMapper.toResponse(book);
        return ResponseEntity.ok(bookResp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Integer id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{bookId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getReviews(@PathVariable("bookId") Integer bookId) {
        var reviews = service.findReviews(bookId);
        var reviewsResp = reviews.stream()
                .map(ReviewResponse::new).toList();
        return ResponseEntity.ok(reviewsResp);
    }

    @PostMapping("{bookId}/reviews")
    public ResponseEntity<ReviewResponse> createReview(@PathVariable("bookId") Integer bookId, @RequestBody @Valid ReviewRequest request) {
        var review = request.getReview();
        review = service.addReview(bookId, review);
        var reviewResp = new ReviewResponse(review);
        return ResponseEntity.created(URI.create("/")).body(reviewResp);
    }

}