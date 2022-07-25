package com.example.springSecurity.Service;

import com.example.springSecurity.Model.User;
import com.example.springSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails userDetails=null;
        if (user != null){
           userDetails = new CustomUserDetails();
           userDetails.setUser(user);
        }else {
            throw new UsernameNotFoundException("Username not exist with this name: "+username);
        }
        return userDetails;
    }
}
