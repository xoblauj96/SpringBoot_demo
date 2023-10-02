package com.example.demo.business;

import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.MLoginRequest;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.model.MRegisterResponse;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserBusiness {

    private final UserMapper userMapper;
    private final UserService userService;

    public UserBusiness(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    public MRegisterResponse register(MRegisterRequest request) throws UserException {
        User user = userService.create(request.getEmail(), request.getPassword(), request.getName());
        MRegisterResponse model = userMapper.toRegisterResponse(user);
        return model;
    }

    public String login(MLoginRequest request) throws UserException {
        Optional<User> opt = userService.findByEmail(request.getEmail());
        if (Objects.isNull(opt)){
            //throw login fail, email not found
            throw UserException.loginFailEmailNotFound();
        }
        if(!opt.isPresent()) {
            throw UserException.loginFailEmailNotFound();
        }
        User user = opt.get();
        if(!userService.matchPassword(request.getPassword(), user.getPassword())){
            //throw login fail, password incorrect
            throw UserException.loginFailEmailNotFound();
        }

        //TODO: generate JWT
         String token ="JWT TO DO";
        return  token;
    }
}
