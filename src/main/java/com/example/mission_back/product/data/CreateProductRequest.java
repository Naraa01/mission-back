package com.example.mission_back.product.data;

import org.hibernate.validator.constraints.Length;

import com.beust.jcommander.internal.Nullable;
import com.example.mission_back.util.Client;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Client
public class CreateProductRequest {
  @NotNull
  @Length(min = 3, message = "must be at least 3 digits long")
  private String name;
  @Nullable
  private String count;
  @Nullable
  private String description;
  @Nullable
  private String price;
  @Nullable
  private String imageUrl;
}