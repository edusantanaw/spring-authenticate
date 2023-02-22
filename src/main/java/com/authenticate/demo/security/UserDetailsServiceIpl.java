package com.authenticate.demo.security;

import com.authenticate.demo.user.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceIpl implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsServiceIpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsSecurity user = (UserDetailsSecurity) userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username );
        }
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getRoles());
    }
}
