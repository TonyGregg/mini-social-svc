package com.genil.learning.minisocialsvc.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Antony Genil on 12/23/19 at 16 05 for mini-social-svc
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoolCarTypeConrollerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CoolCarTypeConroller coolCarTypeConroller;

    @Test
    public void getAllCarTypes() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/car-types/getAllCarTypes/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(7)));
    }
}