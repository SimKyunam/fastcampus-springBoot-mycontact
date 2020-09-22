package com.fastcampus.javaallinone.project3.mycontact.controller;

import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by mileNote on 2020-09-15
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
@SpringBootTest
@Transactional
class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Autowired
    private PersonRepository personRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
    }

    @Test
    void getPerson() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/person/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postPerson() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/person")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                            "  \"name\": \"martin2\",\n" +
                            "  \"age\": 20,\n" +
                            "  \"bloodType\": \"A\"\n" +
                            "}"))
            .andDo(print())
            .andExpect(status().isCreated());
    }

    @Test
    void modifyPerson() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/person/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"name\": \"martin\",\n" +
                                "  \"age\": 20,\n" +
                                "  \"bloodType\": \"A\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyName() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.patch("/api/person/1")
                    .param("name", "martin22"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void deletePerson() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/api/person/1"))
            .andDo(print())
            .andExpect(status().isOk());

    }
}