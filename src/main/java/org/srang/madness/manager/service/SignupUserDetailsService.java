package org.srang.madness.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.srang.madness.manager.model.entities.User;
import org.srang.madness.manager.model.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by srang on 12/17/16.
 */
@Service
@Transactional
public class SignupUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    //
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: "+ username);
        }
        boolean enabled = user.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return  new org.springframework.security.core.userdetails.User
                (user.getEmail(),
                        user.getPassword().toLowerCase(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        getAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        /**
         List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         for (String role : roles) {
         authorities.add(new SimpleGrantedAuthority(role));
         }
         return authorities;
         */
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r))
                .collect(Collectors.toList());
    }
}