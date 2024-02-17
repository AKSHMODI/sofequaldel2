package com.ontariotechu.sofe3980U;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// ... Existing imports ...

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBinaryAdditionAPI() throws Exception {
        this.mockMvc.perform(get("/add").param("operand1", "101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(content().string("1011"));
    }

    @Test
    public void testBinaryAdditionAPI_JSON() throws Exception {
        this.mockMvc.perform(get("/add_json").param("operand1", "101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("1011"));
    }

    @Test
    public void testInvalidOperandAPI() throws Exception {
        this.mockMvc.perform(get("/add").param("operand1", "101").param("operand2", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid binary input"));
    }

    @Test
    public void testBinaryMultiplicationAPI() throws Exception {
        this.mockMvc.perform(get("/multiply").param("operand1", "101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(content().string("11110"));
    }

    @Test
    public void testBinaryANDAPI() throws Exception {
        this.mockMvc.perform(get("/and").param("operand1", "101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(content().string("100"));
    }

    @Test
    public void testBinaryORAPI() throws Exception {
        this.mockMvc.perform(get("/or").param("operand1", "101").param("operand2", "110"))
                .andExpect(status().isOk())
                .andExpect(content().string("111"));
    }

    // Add three more test cases for other scenarios as needed
}
