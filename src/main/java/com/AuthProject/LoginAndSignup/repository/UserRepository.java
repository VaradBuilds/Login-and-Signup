package com.AuthProject.LoginAndSignup.repository;

import com.AuthProject.LoginAndSignup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
}
