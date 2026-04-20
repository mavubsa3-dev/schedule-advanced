package com.example.scheduleadvanced.repository;

import com.example.scheduleadvanced.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
