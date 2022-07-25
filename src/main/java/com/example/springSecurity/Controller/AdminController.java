package com.example.springSecurity.Controller;

import com.example.springSecurity.Model.User;
import com.example.springSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("admin/add")
    public String addUserByAdmin(@RequestBody User user){
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "User Successfully Added";
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/all")
    public String securedHello() {
        return "Secured Hello";
    }


}
