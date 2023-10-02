package com.example.demo.business;

import com.example.demo.exception.BaseException;
import com.example.demo.exception.FileException;
import com.example.demo.exception.UserException;
import com.example.demo.model.MRegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TestBusiness {
    public String register(MRegisterRequest request) throws BaseException {

        if (request == null) {
            throw UserException.requestNull();
        }

        if (Objects.isNull(request.getEmail())) {
            throw UserException.createEmailNull();

        }
        return request.toString();
    }

    public String uploadProfilePicture(MultipartFile file) throws FileException {
        //validate file
        if (file == null) {
            //throw error
            throw FileException.fileNull();
        }

        //validate size
        if (file.getSize() > (1048576 * 2)) {
            throw FileException.fileMaxSize();
        }
        String contentType = file.getContentType();

        if (contentType == null) {
            // throw error
            throw FileException.unsupported();
        }
        List<String> supportedTypes = Arrays.asList("image/jpeg", "image/png");

        if (!supportedTypes.contains(contentType)) {
            //throw error
            throw FileException.unsupported();
        }
        //TODO: upload file File Storage (AWS S3, etc...)
        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}
