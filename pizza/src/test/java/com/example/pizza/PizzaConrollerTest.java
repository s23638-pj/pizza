package com.example.pizza;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PizzaConrollerTest {
    @Autowired
    private MockMvc mockMvc;
//TESTY INTEGRACYJNE
    @Test
    void integration() throws Exception{
        mockMvc.perform(get("/pizza/xyz")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("Działa"));
    }

    @Test
    void integration2()throws Exception{
        mockMvc.perform(get("/pizza/pizza2")
                .param("nazwa", "test")
                .param("rozmiar", "1").param("skladnik1", "test")
                .param("skladnik2", "test").param("skladnik3", "test")
                .param("czy_sos", "true").param("czy_cienkie", "true")
                .param("min_w_piecu", "1").param("dni_fermentacji", "1"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().string("{\"nazwa\":\"test\",\"rozmiar\":1,\"skladnik1\":\"test\",\"skladnik2\":\"test\",\"skladnik3\":\"test\",\"czy_sos\":true,\"czy_cienkie\":true,\"min_w_piecu\":1,\"dni_fermentacji\":1}"));
    }

}
