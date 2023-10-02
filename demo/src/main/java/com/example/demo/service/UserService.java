package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private  final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User create(String email, String password, String name) throws UserException {

        if (Objects.isNull(email)) throw UserException.createEmailNull();

        if (Objects.isNull(password)) throw UserException.createPasswordNull();

        if (Objects.isNull(name)) throw UserException.createNameNull();

        //verify email
        if(userRepository.existsByEmail(email)) throw UserException.createEmailDuplicate();

        User entity = new User();
        entity.setEmail(email);
        entity.setPassword(passwordEncoder.encode(password));
        entity.setName(name);
        return userRepository.save(entity);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean matchPassword(String rawPassword, String encodedPassword){
      return   passwordEncoder.matches(rawPassword,encodedPassword);
    }
}
