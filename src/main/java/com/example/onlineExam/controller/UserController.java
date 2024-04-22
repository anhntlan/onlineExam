package com.example.onlineExam.controller;

import com.example.onlineExam.model.Question;
import com.example.onlineExam.model.User;
import com.example.onlineExam.model.UserLoginRequest;
import com.example.onlineExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/byid/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/admin")
    public List<User> getAdminUsers() {
        return userService.getAdminUsers();
    }
    @GetMapping("/user")
    public List<User> getUserUsers() {
        return userService.getUserUsers();
    }
    @GetMapping("/byname/{username}")
    public Optional<User> getUserByUsername(@PathVariable String name) {
        return userService.getUserByName(name);
    }


    @PostMapping("/add")
    public User saveUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {

        return userService.deleteUser(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User User) {
        boolean isUpdated = userService.updateUserById(id, User);
        if (isUpdated) {
            return ResponseEntity.ok("Updated the user");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy người dùng để cập nhật");
        }
    }
    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest userLoginRequest) {
        boolean isAuthenticated = userService.authenticate(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }

    }
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);
        if (isRegistered) {
            return "User registered successfully!";
        } else {
            return "Failed to register user. Email may already exist.";
        }
    }

}

