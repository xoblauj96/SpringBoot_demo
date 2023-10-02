package com.example.demo.api;

import com.example.demo.business.TestBusiness;
import com.example.demo.exception.BaseException;
import com.example.demo.exception.FileException;
import com.example.demo.model.MRegisterRequest;
import com.example.demo.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/test")
@RestController
public class TestApi {

    // method 1 Field Injection
//    @Autowired
//    private TestBusiness business;

    //    Method 2 => Constructor Injection
    private final TestBusiness business;

    public TestApi(TestBusiness business) {
        this.business = business;
    }

    @GetMapping
    public TestResponse test() {
        TestResponse response = new TestResponse();
        response.setFood("rice");
        response.setName("sor");
        return response;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody MRegisterRequest request) throws BaseException {
        String registers = null;
        registers = this.business.register(request);

        return ResponseEntity.ok(registers);
    }

    @PostMapping
    public ResponseEntity<String> uploadProfilePicture(@RequestParam MultipartFile file) throws FileException {

        String response = business.uploadProfilePicture(file);
        return ResponseEntity.ok(response);
    }
}
