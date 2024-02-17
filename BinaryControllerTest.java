package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// ... Existing imports ...

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BinaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidBinaryAddition() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "101").param("operator", "+").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1011"));
    }

    @Test
    public void testInvalidOperator() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "101").param("operator", "*").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("error"))
                .andExpect(model().attribute("errorMessage", "Invalid operator: *"));
    }

    @Test
    public void testEmptyInput() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "").param("operator", "+").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand2", "110"));
    }

    @Test
    public void testBinaryMultiplication() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "101").param("operator", "*").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"));
    }

    @Test
    public void testBinaryAND() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "101").param("operator", "&").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "100"));
    }

    @Test
    public void testBinaryOR() throws Exception {
        this.mockMvc.perform(get("/").param("operand1", "101").param("operator", "|").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111"));
    }

    // Add three more test cases for other scenarios as needed
}
