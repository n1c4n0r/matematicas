package es.nmc.matematicas.api.v1.controller;

import es.nmc.matematicas.service.NumerosService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class NumerosControllerTest {
    private static final String API_URL = "/api/v1/numeros/sumaCienPrimeros";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private NumerosService numerosService;

    @Test
    void getSumaCienPrimerosNumerosSuccess() throws Exception {
        // Preparación de datos de prueba
        List<Integer> numeros = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());

        // Ejecución de la petición HTTP
        MvcResult result = mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(numeros.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.resultado", equalTo(5050)))
                .andExpect(jsonPath("$.ok", equalTo(true)))
                .andExpect(jsonPath("$.estado", equalTo(200)))
                .andReturn();

        // Verificación de la respuesta
        String content = result.getResponse().getContentAsString();
        assertThat(content).contains("\"resultado\":5050")
                .contains("\"ok\":true")
                .contains("\"estado\":200");
    }



    @Test
    void getSumaCienPrimerosNumeros_whenInvalidList_thenThrowsNumerosNoValidosException() throws Exception {
        List<Integer> invalidNumbers = Collections.nCopies(100, 0);

        mockMvc.perform(post(API_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidNumbers.toString()))
                .andExpect(status().isBadRequest());
    }
}
