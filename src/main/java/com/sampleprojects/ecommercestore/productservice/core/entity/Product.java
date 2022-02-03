package com.sampleprojects.ecommercestore.productservice.core.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

  @Id
  private String productId;

  @Column(unique = true)
  private String title;
  private BigDecimal price;
  private Integer quantity;

}
