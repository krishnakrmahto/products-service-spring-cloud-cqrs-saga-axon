package com.sampleprojects.ecommercestore.productservice.command.controller.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ProductCommandExceptionHandler {

  @ExceptionHandler(IllegalStateException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommandErrorResponseDto handleIllegalStateException(IllegalStateException ex, WebRequest request) {
    return new CommandErrorResponseDto(ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public CommandErrorResponseDto handleAllOtherExceptions(Exception ex, WebRequest request) {
    return new CommandErrorResponseDto(ex.getMessage());
  }
}
