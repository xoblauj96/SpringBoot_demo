package com.example.demo.exception;

public class UserException extends BaseException {
    public UserException(String code) {
        super("user." + code);
    }

    //user.register.email.null
    public static UserException requestNull() {
        return new UserException("register.request.null");
    }

    public static UserException createEmailNull() {
        return new UserException("create.email.null");
    }

    public static UserException createEmailDuplicate() {
        return new UserException("create.email.duplicate");
    }

    public static UserException createNameNull() {
        return new UserException("create.name.null");
    }

    public static UserException createPasswordNull() {
        return new UserException("create.password.null");
    }

    //LOGIN
    public static UserException loginFailEmailNotFound() {
        return new UserException("login.fail");
    }

    public static UserException loginPasswordIncorrect() {
        return new UserException("login.fail");
    }


}
