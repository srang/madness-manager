package com.github.srang.madness.service;

import com.github.srang.madness.model.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.srang.madness.model.types.Status;
import com.github.srang.madness.model.entities.User;
import com.github.srang.madness.model.forms.RegisterForm;

/**
 * Created by srang on 12/10/16.
 */
@Service
@Log
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Transactional
    public User registerUser(RegisterForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .password(hashPassword(form.getPassword()))
                .username(form.getUsername())
                .status(Status.StatusType.ACTIVE.status())
                .build();
        user.addRole("ROLE_USER");
        return userRepository.save(user);
    }

    public String hashPassword(String plainPass) {
        return encoder.encode(plainPass);
    }
}
