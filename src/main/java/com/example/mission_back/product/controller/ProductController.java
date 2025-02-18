package com.example.mission_back.product.controller;

import com.example.mission_back.product.data.CreateProductRequest;
import com.example.mission_back.product.data.ProductResponse;
import com.example.mission_back.product.service.ProductService;
import com.example.mission_back.util.Client;
import com.example.mission_back.util.PaginationResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Client
public class ProductController {
  private final ProductService productService;
  private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

  @PostMapping("/create")
  public ResponseEntity<ProductResponse> createUser(@Valid @RequestBody CreateProductRequest request) {
    ProductResponse user = productService.create(request);
    return ResponseEntity.ok(user);
  }

  @GetMapping(value = "/list", produces = "application/json")
  public ResponseEntity<PaginationResponse> getAllProducts(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int max,
      @RequestParam(required = false) String q) {
    PaginationResponse paginationResponse = productService.findAll(page, max, q);

    logger.info("Getting product list ->");
    return ResponseEntity.ok(paginationResponse);
  }
  // public ResponseEntity<List<ProductResponse>> getAllProducts() {
  // List<ProductResponse> products = productService.findAll();
  // return ResponseEntity.ok(products);
  // }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
    ProductResponse product = productService.findOne(id);
    return ResponseEntity.ok(product);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
      @Valid @RequestBody CreateProductRequest request) {
    ProductResponse product = productService.update(id, request);
    return ResponseEntity.ok(product);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
