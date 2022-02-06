package com.sampleprojects.ecommercestore.productservice.command.controller.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProductDto {

  @NotBlank(message = "Product title is required")
  private String title;

  @Min(value = 1, message = "Price cannot be lower than 1")
  private BigDecimal price;

  @Min(value = 1, message = "Quantity cannot be lower than 1")
  @Max(value = 10, message = "Quantity cannot be greater than 10")
  private Integer quantity;
}
