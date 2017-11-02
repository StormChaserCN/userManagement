package com.fhyd.userManagement.repository;

import com.fhyd.userManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
