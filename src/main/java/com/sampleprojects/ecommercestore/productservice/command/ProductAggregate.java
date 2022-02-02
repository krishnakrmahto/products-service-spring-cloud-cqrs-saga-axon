package com.sampleprojects.ecommercestore.productservice.command;

import java.math.BigDecimal;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

  @CommandHandler
  public ProductAggregate(CreateProductCommand createProductCommand) {

    // Validate createProductCommand
    if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }

    if(createProductCommand.getTitle() != null && !createProductCommand.getTitle().isBlank()) {
      throw new IllegalArgumentException("Product title cannot be empty");
    }


  }

}
