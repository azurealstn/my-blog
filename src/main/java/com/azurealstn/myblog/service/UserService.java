package com.azurealstn.myblog.service;

import com.azurealstn.myblog.model.User;
import com.azurealstn.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void userJoin(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User userLogin(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
