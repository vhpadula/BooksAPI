package com.vhpadula.booksapi.booksapi.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor  @AllArgsConstructor
public class ReviewRequest {

    @NotEmpty(message = "{required.field}")
    @Size(min = 1, max = 200, message = "{invalid.field}")
    private String review;

}
