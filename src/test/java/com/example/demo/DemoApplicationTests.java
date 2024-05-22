package com.example.demo;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class DemoApplicationTests {

    @InjectMocks
    DemoApplication demoApplication;

    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        System.out.println("DemoApplicationTests.init");
        mockMvc = MockMvcBuilders
                .standaloneSetup(demoApplication)
                .build();
    }

    @Test
    public void test_greetPerson() throws Exception {
        String name = demoApplication.greetPerson("Rock");
        assertEquals("hello Rock Kumar", name);

//        assertEquals("hello Rock Kumar", mockMvc.perform(MockMvcRequestBuilders
//                        .get("/hi/Rock")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk()).andReturn().getResponse());
    }

    @Test(expected = InvalidParameterException.class)
    public void test_greetPersonWithInvalidInput() {
        String name = demoApplication.greetPerson("");

    }

    @AfterEach
    public void cleanUp() {
        System.out.println("DemoApplicationTests.cleanUp");
    }

}
