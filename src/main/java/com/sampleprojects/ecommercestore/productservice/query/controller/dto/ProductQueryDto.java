package com.sampleprojects.ecommercestore.productservice.query.controller.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductQueryDto {

  private String productId;
  private String title;
  private BigDecimal price;
  private Integer quantity;

}
