package com.example.mission_back.users.data;

import com.example.mission_back.util.Client;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Client
public class ForgotPasswordRequest {
  @Email
  private String email;
}
