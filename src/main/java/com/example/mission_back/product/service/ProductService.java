package com.example.mission_back.product.service;

import com.example.mission_back.product.repository.ProductRepository;
import com.example.mission_back.util.PaginationResponse;
import com.example.mission_back.product.Product;
import com.example.mission_back.product.data.CreateProductRequest;
import com.example.mission_back.product.data.ProductResponse;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  @Transactional
  public ProductResponse create(@Valid CreateProductRequest request) {
    Product product = new Product(request);
    product = productRepository.save(product);
    return new ProductResponse(product);
  }

  @Transactional(readOnly = true)
  public PaginationResponse findAll(int page, int max, String q) {
    Pageable pageable = PageRequest.of(page - 1, max);
    Page<Product> productPage;

    try {
      if (q == null || q.isEmpty()) {
        productPage = productRepository.findAll(pageable);
      } else {
        productPage = productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(q, q, pageable);
      }

      List<ProductResponse> productResponses = productPage.getContent().stream()
          .map(ProductResponse::new)
          .toList();

      return new PaginationResponse(productResponses, productPage.getNumber() + 1, productPage.getTotalElements(),
          productPage.getTotalPages());
    } catch (Exception e) {
      throw new RuntimeException("Error occurred while fetching products", e);
    }
  }

  @Transactional(readOnly = true)
  public ProductResponse findOne(Long id) {
    Optional<Product> product = productRepository.findById(id);
    return product.map(ProductResponse::new).orElseThrow(() -> new RuntimeException("Product not found"));
  }

  @Transactional
  public ProductResponse update(Long id, CreateProductRequest request) {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));

    product.setName(request.getName());
    product.setCount(request.getCount());
    product.setDescription(request.getDescription());
    product.setPrice(request.getPrice());
    product.setImageUrl(request.getImageUrl());
    product = productRepository.save(product);
    return new ProductResponse(product);
  }

  @Transactional
  public void delete(Long id) {
    productRepository.deleteById(id);
  }
}
