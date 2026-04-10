package com.example.backendmodule.integration.api;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BeneficioIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void fluxoCompleto() throws Exception {

        var json = """
        {
          "nome": "Vale Refeição de Teste",
          "descricao": "Teste",
          "valor": 500
        }
        """;

        mockMvc.perform(post("/api/v1/beneficios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(get("/api/v1/beneficios"))
                .andExpect(status().isOk());
    }
}
