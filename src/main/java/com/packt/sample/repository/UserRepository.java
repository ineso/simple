package com.packt.sample.repository;

import com.packt.sample.entity.UserAPP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAPP, Long> {
 
    UserAPP findByUsername(String username);

}