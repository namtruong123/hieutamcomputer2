// src/main/java/com/hieutamcomputer/ecommerce/model/Admin.java

package com.hieutamcomputer.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idAdmin;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_user", nullable = false, unique = true)
    private String adminUser;

    @Column(name = "admin_pass", nullable = false)
    private String adminPass;

    @Column(name = "position")
    private String position;

    @Column(name = "address")
    private String address;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
