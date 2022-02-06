package com.sampleprojects.ecommercestore.productservice.command;

import com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.entity.ProductLookup;
import com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.repository.ProductLookupRepository;
import com.sampleprojects.ecommercestore.productservice.core.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@ProcessingGroup("product-processors")
@Component
@RequiredArgsConstructor
public class ProductLookupEventstHandler {

  private final ProductLookupRepository productLookupRepository;

  @EventHandler
  public void on(ProductCreatedEvent event) {

    ProductLookup productLookup = new ProductLookup(event.getProductId(), event.getTitle());
    productLookupRepository.save(productLookup);
  }
}
