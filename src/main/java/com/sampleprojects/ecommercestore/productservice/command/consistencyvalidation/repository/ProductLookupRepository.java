package com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.repository;

import com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.entity.ProductLookup;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookup, String> {

  Optional<ProductLookup> findByProductIdOrTitle(String productId, String title);
}
