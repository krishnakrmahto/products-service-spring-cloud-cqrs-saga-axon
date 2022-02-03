package com.sampleprojects.ecommercestore.productservice.core.repository;

import com.sampleprojects.ecommercestore.productservice.core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

  Product findProductByProductIdOrTitle(String productId, String title);
}
