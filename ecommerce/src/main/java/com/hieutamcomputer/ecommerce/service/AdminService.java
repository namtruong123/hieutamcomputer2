// src/main/java/com/hieutamcomputer/ecommerce/service/AdminService.java

package com.hieutamcomputer.ecommerce.service;

import com.hieutamcomputer.ecommerce.model.Admin;
import com.hieutamcomputer.ecommerce.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void saveAdmin(Admin admin) {
        admin.setAdminPass(passwordEncoder.encode(admin.getAdminPass()));
        adminRepository.save(admin);
    }

    public boolean existsByAdminUser(String adminUser) {
        return adminRepository.findByAdminUser(adminUser).isPresent();
    }
}
