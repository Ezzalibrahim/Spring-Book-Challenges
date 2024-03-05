package com.books.DTOs;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    private int status;
}
