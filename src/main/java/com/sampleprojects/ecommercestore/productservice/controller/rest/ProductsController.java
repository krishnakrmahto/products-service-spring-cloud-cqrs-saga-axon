package com.sampleprojects.ecommercestore.productservice.controller.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

  @PostMapping
  public String createProduct() {
    return "Handled POST request";
  }

  @PostMapping
  public String getProducts() {
    return "Handled GET request for all products";
  }

  @PutMapping("/{id}")
  public String updateProduct(@PathVariable String id) {
    return "Handled PUT request for product id: " + id;
  }

  @DeleteMapping("/{id}")
  public String deleteProduct(@PathVariable String id) {
    return "Handled DELETE request for product id: " + id;
  }
}
