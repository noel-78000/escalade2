package com.ocr.noel.escalade2.service;

import com.ocr.noel.escalade2.entity.User;
import com.ocr.noel.escalade2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        System.out.println("dans findAllUser " + users.size());
        return users;
    }

    public User findByIdFetchAddress(Long id) {
        return userRepository.findByIdFetchAddress(id).orElse(null);
    }
}
