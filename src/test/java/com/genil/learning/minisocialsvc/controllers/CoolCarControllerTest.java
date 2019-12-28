package com.genil.learning.minisocialsvc.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


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
public class CoolCarControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CoolCarController coolCarController;


    @Test
    public void getAllCars() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cars-social/getAllCars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(10)));
    }


    @Test
    public void getCar() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cars-social/getCar/3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("BMW i3"));
    }
}