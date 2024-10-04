// src/main/java/com/hieutamcomputer/ecommerce/controller/AdminAuthController.java

package com.hieutamcomputer.ecommerce.controller;

import com.hieutamcomputer.ecommerce.model.Admin;
import com.hieutamcomputer.ecommerce.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminAuthController {

    private final AdminService adminService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/register";
    }

    @PostMapping("/register")
    public String registerAdmin(@Valid @ModelAttribute("admin") Admin admin,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            return "admin/register";
        }
        if (adminService.existsByAdminUser(admin.getAdminUser())) {
            model.addAttribute("userError", "Username đã tồn tại");
            return "admin/register";
        }
        adminService.saveAdmin(admin);
        return "redirect:/admin/login?registerSuccess";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "admin/dashboard";
    }
}
