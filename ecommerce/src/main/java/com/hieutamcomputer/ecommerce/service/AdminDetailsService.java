// src/main/java/com/hieutamcomputer/ecommerce/service/AdminDetailsService.java

package com.hieutamcomputer.ecommerce.service;

import com.hieutamcomputer.ecommerce.model.Admin;
import com.hieutamcomputer.ecommerce.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng với username: " + username));
        return User.builder()
                .username(admin.getAdminUser())
                .password(admin.getAdminPass())
                .roles("ADMIN") // Bạn có thể điều chỉnh quyền nếu cần
                .build();
    }
}
