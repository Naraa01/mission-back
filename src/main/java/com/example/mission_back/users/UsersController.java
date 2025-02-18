package com.example.mission_back.users;

import com.example.mission_back.config.ApplicationProperties;
import com.example.mission_back.users.data.CreateUserRequest;
import com.example.mission_back.users.data.UserResponse;
import com.example.mission_back.users.service.UserService;
import com.example.mission_back.util.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Client
public class UsersController {
  private final UserService userService;
  private final ApplicationProperties applicationProperties;

  @PostMapping
  public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
    UserResponse user = userService.create(request);
    return ResponseEntity.ok(user);
  }
}
