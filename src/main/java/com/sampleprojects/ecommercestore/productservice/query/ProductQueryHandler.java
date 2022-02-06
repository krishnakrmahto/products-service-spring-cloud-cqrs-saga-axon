package com.sampleprojects.ecommercestore.productservice.query;

import com.sampleprojects.ecommercestore.productservice.core.repository.ProductRepository;
import com.sampleprojects.ecommercestore.productservice.query.controller.dto.ProductQueryDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductQueryHandler {

  private final ProductRepository productRepository;

  @QueryHandler
  public List<ProductQueryDto> findAllProducts(FindAllProductQuery query) {
    return productRepository.findAll().stream()
        .map(entity -> ProductQueryDto.builder()
            .productId(entity.getProductId())
            .title(entity.getTitle())
            .price(entity.getPrice())
            .quantity(entity.getQuantity())
            .build())
        .collect(Collectors.toList());
  }

}
