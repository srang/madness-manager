package org.srang.madness.manager.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.srang.madness.manager.model.entities.Status;
import org.srang.madness.manager.model.entities.User;
import org.srang.madness.manager.model.entities.UserRole;
import org.srang.madness.manager.model.forms.RegisterForm;
import org.srang.madness.manager.model.repositories.UserRepository;

import java.util.List;

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

    public User addRolesToUser(User user, List<String> roles) {
        return user;
    }

    @Transactional
    public User registerUser(RegisterForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .password(hashPassword(form.getPassword()))
                .username(form.getUsername())
                .status(Status.StatusType.ACTIVE.status())
                .userRole(new UserRole(form.getUsername(), "ROLE_USER"))
                .build();
        return userRepository.save(user);
    }

    public String hashPassword(String plainPass) {
        return encoder.encode(plainPass);
    }
}
