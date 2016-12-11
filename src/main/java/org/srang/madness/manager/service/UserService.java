package org.srang.madness.manager.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srang.madness.manager.model.entities.Status;
import org.srang.madness.manager.model.entities.User;
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

    public User addRolesToUser(User user, List<String> roles) {
        return user;
    }

    public User registerUser(RegisterForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .password(form.getFavoriteTeam())
                .username(form.getUsername())
                .status(Status.StatusType.ACTIVE.status())
                .build();
        userRepository.save(user);
        return user;
    }
}
