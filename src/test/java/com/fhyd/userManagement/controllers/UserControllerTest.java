package com.fhyd.userManagement.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void addUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name1/department1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name2/department1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name3/department1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name4/department2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name5/department2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/users/add/name6/department2").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAllUser() throws Exception {
        addUsers();
        mvc.perform(MockMvcRequestBuilders.get("/users/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void deleteUser() throws Exception {
        addUsers();
        mvc.perform(MockMvcRequestBuilders.get("/users/delete/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

}
