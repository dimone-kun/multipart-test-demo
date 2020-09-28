package com.example.multiparttestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.Part;
import java.io.IOException;

@SpringBootApplication
@EnableWebMvc
public class MultipartTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipartTestDemoApplication.class, args);
    }
}

@RestController
class HelloWorldController {
    @RequestMapping(path = "helloworld", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public String helloWorld(@RequestPart(name = "part0") String str0,
                             @RequestPart(name = "part1") String str1) {
        return str0+str1;
    }
}
