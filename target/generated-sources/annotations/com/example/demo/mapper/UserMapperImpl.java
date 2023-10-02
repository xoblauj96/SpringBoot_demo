package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.MRegisterResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-01T20:36:02+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public MRegisterResponse toRegisterResponse(User user) {
        if ( user == null ) {
            return null;
        }

        MRegisterResponse mRegisterResponse = new MRegisterResponse();

        mRegisterResponse.setEmail( user.getEmail() );
        mRegisterResponse.setName( user.getName() );

        return mRegisterResponse;
    }
}
