package com.example.onlineExam.service;

import com.example.onlineExam.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  interface UserService {
     public User create(User user) ;
     public String deleteUser(Integer id);
     public List<User> getAllUsers();
     public User getUserById(Integer id);
     public List<User> getAdminUsers() ;
     public List<User> getUserUsers() ;
     public Optional<User> getUserByName(String username);
     public boolean updateUserById(int id, User user);
     public boolean authenticate(String email, String password);

     public boolean registerUser(User user);
}
