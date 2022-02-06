package com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.repository;

import com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.entity.ProductLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookup, String> {

  ProductLookup findByProductIdOrTitle(String productId, String title);
}
