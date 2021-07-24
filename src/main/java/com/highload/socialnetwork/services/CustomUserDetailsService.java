package com.highload.socialnetwork.services;

import com.highload.socialnetwork.model.persistense.AccessRole;
import com.highload.socialnetwork.model.persistense.User;
import com.highload.socialnetwork.services.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with login: " + login);
        }
        return getPrincipal(user);
    }

    private org.springframework.security.core.userdetails.User getPrincipal(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                getAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> getAuthorities(List<AccessRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (AccessRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }
}
