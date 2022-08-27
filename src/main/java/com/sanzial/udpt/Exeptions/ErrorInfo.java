package com.sanzial.udpt.Exeptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorInfo {
    private final String message;
    private final HttpStatus status;
}
