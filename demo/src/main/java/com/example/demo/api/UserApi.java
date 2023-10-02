package com.example.demo.api;

import com.example.demo.business.UserBusiness;
import com.example.demo.entity.User;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.UserException;
import com.example.demo.model.MLoginRequest;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.model.MRegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {
    private final UserBusiness userBusiness;

    public UserApi(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<MRegisterResponse> register(@RequestBody MRegisterRequest request) throws BaseException {
        MRegisterResponse response = userBusiness.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MLoginRequest request) throws BaseException {
      String r =  userBusiness.login(request);
     return  ResponseEntity.ok(r);
    }
}
