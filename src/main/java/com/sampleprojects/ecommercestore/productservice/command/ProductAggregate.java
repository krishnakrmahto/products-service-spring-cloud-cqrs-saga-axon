package com.sampleprojects.ecommercestore.productservice.command;

import com.sampleprojects.ecommercestore.productservice.core.event.ProductCreatedEvent;
import java.math.BigDecimal;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
public class ProductAggregate {

  @AggregateIdentifier
  private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;

  @CommandHandler
  public ProductAggregate(CreateProductCommand createProductCommand) {

    // Validate createProductCommand
    if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }

    if(createProductCommand.getTitle() != null && !createProductCommand.getTitle().isBlank()) {
      throw new IllegalArgumentException("Product title cannot be empty");
    }

    ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder()
        .productId(createProductCommand.getProductId())
        .title(createProductCommand.getTitle())
        .price(createProductCommand.getPrice())
        .quantity(createProductCommand.getQuantity())
        .build();

    AggregateLifecycle.apply(productCreatedEvent);
  }

  @EventSourcingHandler
  public void on(ProductCreatedEvent event) {
    productId = event.getProductId();
    title = event.getTitle();
    price = event.getPrice();
    quantity = event.getQuantity();
  }

}
