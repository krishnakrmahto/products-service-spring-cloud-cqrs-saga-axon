package com.sampleprojects.ecommercestore.productservice.controller.rest;

import com.sampleprojects.ecommercestore.productservice.controller.rest.dto.CreateProductDto;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

  private final Environment environment;

  @PostMapping
  public String createProduct(@RequestBody CreateProductDto createProductDto) {
    return "Handled POST request, port: " + environment.getProperty("local.server.port") + " productTitle: " + createProductDto.getTitle();
  }

  @GetMapping
  public String getProducts() {
    return "Handled GET request for all products, port: " + environment.getProperty("local.server.port");
  }

  @PutMapping("/{id}")
  public String updateProduct(@PathVariable String id) {
    return "Handled PUT request for product id: " + id + ", port: " + environment.getProperty("local.server.port");
  }

  @DeleteMapping("/{id}")
  public String deleteProduct(@PathVariable String id) {
    return "Handled DELETE request for product id: " + id + ", port: " + environment.getProperty("local.server.port");
  }
}
