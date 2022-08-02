package com.example.webtaskmanager.service;

import com.example.webtaskmanager.model.AccountDetail;
import com.example.webtaskmanager.model.User;
import com.example.webtaskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        AccountDetail account = new AccountDetail(user);
        return account;
    }
}
