package com.example.onlineExam.service.impl;

import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.User;
import com.example.onlineExam.repository.UserRepository;
import com.example.onlineExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Integer id) {
         userRepository.deleteById(id);
        return "Deleted an user ";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAdminUsers() {
        return userRepository.findByRole("ADMIN");
    }

    @Override
    public List<User> getUserUsers() {
        return userRepository.findByRole("USER");
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public boolean updateUserById(int id, User user) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User exist = existingUserOptional.get();
            exist.setName(user.getName());
            exist.setEmail(user.getEmail());
            exist.setRole(user.getRole());
            exist.setPassword(user.getPassword());

            userRepository.save(exist);
            return true;
        }
        return false;
    }



    @Override
    public boolean authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    @Override
    public boolean registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false; // Email already exists
        }

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());

        userRepository.save(newUser);
        return true;
    }


}
