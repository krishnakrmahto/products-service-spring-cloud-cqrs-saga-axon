package com.sampleprojects.ecommercestore.productservice.command;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Command class is generally a plain Java object, that contains all the information for a product to be created.
 * Command class should ideally be a read-only class.
 * It contains a productId field, along with all the fields from CreateProductDto.
 * TargetAggregateIdentifier annotation is used by AxonFramework to associate the Command class with an Aggregate object in your application.
 */

@Value
@Builder
public class CreateProductCommand {
  @TargetAggregateIdentifier
  String productId;
  String title;
  BigDecimal price;
  Integer quantity;
}
