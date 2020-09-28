package com.example.multiparttestdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockPart;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class MultipartTestDemoApplicationTests {

    @Autowired
    MockMvc web;

    @Test
    void helloWorldTest() throws Exception {
        MockPart part0 = new MockPart("part0", "Hello".getBytes());
        part0.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        MockPart part1 = new MockPart("part1", "World".getBytes());
        part1.getHeaders().setContentType(MediaType.TEXT_PLAIN);

        web.perform(multipart("/helloworld")
                .part(part0, part1))
                .andExpect(status().isOk())
                .andExpect(content().string("HelloWorld"));
    }
}
