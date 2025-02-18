package com.example.mission_back.product;

import com.example.mission_back.entity.AbstractEntity;
import com.example.mission_back.product.data.CreateProductRequest;
import com.example.mission_back.util.Client;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Client
public class Product extends AbstractEntity {
  private String name;
  private String count;
  private String description;
  private String price;
  private String imageUrl;

  public Product(CreateProductRequest data) {
    this.name = data.getName();
    this.count = data.getCount();
    this.description = data.getDescription();
    this.price = data.getPrice();
    this.imageUrl = data.getImageUrl();
  }
}
