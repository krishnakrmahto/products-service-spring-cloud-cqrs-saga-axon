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

  /**
   * We may want to do bean validations at HTTP request level or perhaps in a MessageDispatchInterceptor implementation.
   * Ideally, validations in CommandHandler should validate against the current state of the Aggregate, and/or against
   * domain/business related rules since Aggregate contains business and decision-making logic.
   * @param createProductCommand
   */
  @CommandHandler
  public ProductAggregate(CreateProductCommand createProductCommand) {

    /* *** More validations against current state of aggregate and other business logic related validations *** */

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
