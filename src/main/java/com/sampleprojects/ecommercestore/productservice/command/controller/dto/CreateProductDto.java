package com.sampleprojects.ecommercestore.productservice.command.controller.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateProductDto {

  private String title;
  private BigDecimal price;
  private Integer quantity;
}
