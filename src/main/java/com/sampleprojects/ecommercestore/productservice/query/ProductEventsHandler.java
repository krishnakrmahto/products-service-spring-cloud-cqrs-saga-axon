package com.sampleprojects.ecommercestore.productservice.query;

import com.sampleprojects.ecommercestore.productservice.core.entity.Product;
import com.sampleprojects.ecommercestore.productservice.core.event.ProductCreatedEvent;
import com.sampleprojects.ecommercestore.productservice.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.stereotype.Component;

@ProcessingGroup("product-processors")
@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

  private final ProductRepository productRepository;

  @ExceptionHandler(resultType = IllegalArgumentException.class)
  public void handle(IllegalArgumentException exception) {
    throw exception;
  }

  @ExceptionHandler(resultType = Exception.class)
  public void handle(Exception exception) {
    throw new RuntimeException(exception);
  }

  @EventHandler
  public void on(ProductCreatedEvent event) {

    Product product = Product.builder()
        .productId(event.getProductId())
        .title(event.getTitle())
        .price(event.getPrice())
        .quantity(event.getQuantity())
        .build();

    productRepository.save(product);
  }
}
