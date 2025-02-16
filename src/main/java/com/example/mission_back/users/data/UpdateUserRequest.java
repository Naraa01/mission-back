package com.example.mission_back.users.data;

import com.example.mission_back.util.Client;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Client
public class UpdateUserRequest {
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;
}
