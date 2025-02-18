package com.example.mission_back.product.data;

import com.example.mission_back.product.Product;
import com.example.mission_back.util.Client;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
@Client
public class ProductResponse {
  private Long id;
  private String name;
  @Nullable
  private String count;
  @Nullable
  private String description;
  @Nullable
  private String price;
  @Nullable
  private String imageUrl;

  public ProductResponse(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.count = product.getCount();
    this.description = product.getDescription();
    this.price = product.getPrice();
    this.imageUrl = product.getImageUrl();
  }
}
