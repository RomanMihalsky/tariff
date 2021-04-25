package com.faustov.tariff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faustov.tariff.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
  public User findUserByUsername(String username);
  
}
