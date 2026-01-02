package org.marouane.supplychainx2.supplier.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // important!


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class SupplierControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "admin", roles = {"GESTIONNAIRE_APPROVISIONNEMENT"})
    void create() throws Exception {
        String json = """
                {
                    "firstName": "Marouane",
                    "lastName": "Bichara",
                    "contact": "0612345678",
                    "rating": 4.5,
                    "leadTime": 7
                }
                """;

        mockMvc.perform(post("/api/supplier")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Marouane"))
                .andExpect(jsonPath("$.lastName").value("Bichara"))
                .andExpect(jsonPath("$.rating").value(4.5))
                .andExpect(jsonPath("$.leadTime").value(7));
    }
}