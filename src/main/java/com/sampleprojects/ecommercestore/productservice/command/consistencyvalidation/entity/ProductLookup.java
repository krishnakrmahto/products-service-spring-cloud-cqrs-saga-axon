package com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class ProductLookup {

  @Id
  private String productId;

  @Column(unique = true)
  private String title;
}
