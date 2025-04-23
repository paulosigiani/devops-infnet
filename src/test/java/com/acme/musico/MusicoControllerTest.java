package com.acme.musico;

import com.acme.musico.model.Musico;
import com.acme.musico.service.MusicoService;
import com.acme.musico.controller.MusicoController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(MusicoController.class)
class MusicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicoService musicoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfMusicos() throws Exception {
        Musico musico = Musico.builder()
                .id(1L)
                .nome("João")
                .idade(30)
                .cpf("123.456.789-00")
                .sexo("M")
                .cep("12345-678")
                .build();

        Mockito.when(musicoService.findAll()).thenReturn(Arrays.asList(musico));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João"))
                .andExpect(jsonPath("$[0].idade").value(30))
                .andExpect(jsonPath("$[0].cpf").value("123.456.789-00"))
                .andExpect(jsonPath("$[0].sexo").value("M"))
                .andExpect(jsonPath("$[0].cep").value("12345-678"));
    }

    @Test
    void shouldReturnMusicoById() throws Exception {
        Musico musico = Musico.builder()
                .id(1L)
                .nome("Maria")
                .idade(25)
                .cpf("987.654.321-00")
                .sexo("F")
                .cep("23456-789")
                .build();

        Mockito.when(musicoService.findById(1L)).thenReturn(Optional.of(musico));

        mockMvc.perform(get("/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Maria"))
                .andExpect(jsonPath("$.idade").value(25))
                .andExpect(jsonPath("$.cpf").value("987.654.321-00"))
                .andExpect(jsonPath("$.sexo").value("F"))
                .andExpect(jsonPath("$.cep").value("23456-789"));
    }

    @Test
    void shouldReturnNotFoundForInvalidId() throws Exception {
        Mockito.when(musicoService.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateMusico() throws Exception {
        Musico musico = Musico.builder()
                .id(2L)
                .nome("Carlos")
                .idade(40)
                .cpf("111.222.333-44")
                .sexo("M")
                .cep("34567-890")
                .build();

        Mockito.when(musicoService.create(any(Musico.class))).thenReturn(musico);

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(musico)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Carlos"))
                .andExpect(jsonPath("$.idade").value(40))
                .andExpect(jsonPath("$.cpf").value("111.222.333-44"))
                .andExpect(jsonPath("$.sexo").value("M"))
                .andExpect(jsonPath("$.cep").value("34567-890"));
    }

    @Test
    void shouldUpdateMusico() throws Exception {
        Musico musico = Musico.builder()
                .id(1L)
                .nome("Joana")
                .idade(28)
                .cpf("555.666.777-88")
                .sexo("F")
                .cep("45678-901")
                .build();

        mockMvc.perform(put("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(musico)))
                .andExpect(status().isOk());

        Mockito.verify(musicoService).update(any(Musico.class));
    }

    @Test
    void shouldDeleteMusico() throws Exception {
        mockMvc.perform(delete("/1"))
                .andExpect(status().isOk());

        Mockito.verify(musicoService).deleteById(1L);
    }
}
