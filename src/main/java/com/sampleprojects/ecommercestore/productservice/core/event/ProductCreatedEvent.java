package com.sampleprojects.ecommercestore.productservice.core.event;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCreatedEvent {

  String productId;
  String title;
  BigDecimal price;
  Integer quantity;

}
