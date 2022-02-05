package com.sampleprojects.ecommercestore.productservice.core.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  private String productId;

  @Column(unique = true)
  private String title;
  private BigDecimal price;
  private Integer quantity;

}
