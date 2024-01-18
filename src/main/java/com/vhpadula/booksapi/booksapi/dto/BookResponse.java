package com.vhpadula.booksapi.booksapi.dto;
import lombok.Data;

@Data
public class BookResponse {

    private Integer id;
    private String title;
    private String language;
    private Integer yearOfPublication;
    private String authors;

}
