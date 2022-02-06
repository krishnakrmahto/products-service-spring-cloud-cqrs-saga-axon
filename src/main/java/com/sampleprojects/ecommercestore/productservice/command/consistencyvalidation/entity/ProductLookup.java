package com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLookup {

  @Id
  private String productId;

  @Column(unique = true)
  private String title;
}
