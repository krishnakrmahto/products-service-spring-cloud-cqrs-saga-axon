package com.sampleprojects.ecommercestore.productservice.controller.rest.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateProductDto {

  private String title;
  private BigDecimal price;
  private Integer quantity;
}
