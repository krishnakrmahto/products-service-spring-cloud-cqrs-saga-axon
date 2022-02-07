package com.sampleprojects.ecommercestore.productservice.command.controller.errorhandling;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class CommandErrorResponseDto {
  String errorMessage;
}
