package com.example.mission_back.entity;

import java.time.LocalDateTime;

// import com.example.mission_back.enums.CommonStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.SQLDelete;
// import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import lombok.*;

// @Getter
// @Setter
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() WHERE id = ?") // Soft delete
// @Where(clause = "deleted_at IS NULL") // Зөвхөн идэвхтэй өгөгдлийг авах
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = false)
    private String password;

    // @Column(nullable = false, updatable = false)
    // @CreationTimestamp
    // private LocalDateTime createdAt;

    // @Column(nullable = true)
    // @UpdateTimestamp
    // private LocalDateTime updatedAt;

    // @Column(nullable = true)
    // private LocalDateTime deletedAt;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false)
    // private CommonStatus status = CommonStatus.ACTIVE;
}
