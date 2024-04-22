package com.example.onlineExam.repository;

import com.example.onlineExam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(String admin);

    Optional<User> findByName(String username);
    Optional<User> findByEmail(String username);
    boolean existsByEmail(String email);
}
