package com.faustov.tariff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faustov.tariff.entity.User;
import com.faustov.tariff.repository.RoleRepository;
import com.faustov.tariff.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
  
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    
    
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
      this.userRepository = userRepository;
      this.roleRepository = roleRepository;
    }

    
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    
    public User findByUsername(String username) {
        User result = userRepository.findUserByUsername(username);       
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }
}

