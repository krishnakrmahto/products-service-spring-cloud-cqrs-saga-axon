package com.sampleprojects.ecommercestore.productservice.query.controller.rest;

import com.sampleprojects.ecommercestore.productservice.query.FindAllProductQuery;
import com.sampleprojects.ecommercestore.productservice.query.controller.dto.ProductQueryResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {

  private final QueryGateway queryGateway;

  @GetMapping
  public List<ProductQueryResponseDto> getProducts() {

    FindAllProductQuery query = new FindAllProductQuery();

    return queryGateway.query(query, ResponseTypes.multipleInstancesOf(ProductQueryResponseDto.class)).join();
  }
}
