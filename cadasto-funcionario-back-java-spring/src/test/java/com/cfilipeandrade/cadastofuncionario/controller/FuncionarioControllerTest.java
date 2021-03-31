package com.cfilipeandrade.cadastofuncionario.controller;

import com.cfilipeandrade.cadastofuncionario.builder.FuncionarioBuilderDTO;
import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.service.FuncionarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.cfilipeandrade.cadastofuncionario.utils.JsonConvertionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class FuncionarioControllerTest {

    private static final String FUNCIONARIOS_API_URL_PATH = "/api/v1/funcionarios";
    private static final String VALID_FUNCIONARIO_CPF = "000.000.000-43";
    private static final String INVALID_FUNCIONARIO_CPF = "858585888";

    private MockMvc mockMvc;

    @Mock
    private FuncionarioService funcionarioService;

    @InjectMocks
    private FuncionarioController funcionarioController;

    @Test
    void whenPOSTIsCalledThenAFuncionarioIsCreated() throws Exception {
        // given
        FuncionarioDTO funcionarioDTO = FuncionarioBuilderDTO.builder().build().toFuncionarioDTO();

        // when
        when(funcionarioService.createFuncionario(funcionarioDTO)).thenReturn(funcionarioDTO);

        // then
        mockMvc.perform(post(FUNCIONARIOS_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(funcionarioDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome", is(funcionarioDTO.getNome())))
                .andExpect(jsonPath("$.cpf", is(funcionarioDTO.getCpf())))
                .andExpect(jsonPath("$.telefone", is(funcionarioDTO.getTelefone().toString())))
                .andExpect(jsonPath("$.telefone2", is(funcionarioDTO.getTelefone2())))
                .andExpect(jsonPath("$.telefone3", is(funcionarioDTO.getTelefone3())))
                .andExpect(jsonPath("$.email", is(funcionarioDTO.getEmail())))
                .andExpect(jsonPath("$.loja", is(funcionarioDTO.getLoja().getNomeFantasia())));

    }
    @Test
    void whenGETIsCalledWithValidNameThenOkStatusIsReturned() throws Exception {
        // given
         FuncionarioDTO funcionarioDTO = FuncionarioBuilderDTO.builder().build().toFuncionarioDTO();

         // when
        when(funcionarioService.findByNome(funcionarioDTO.getNome())).thenReturn(funcionarioDTO);

        // then
        mockMvc.perform(post(FUNCIONARIOS_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(funcionarioDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome", is(funcionarioDTO.getNome())))
                .andExpect(jsonPath("$.cpf", is(funcionarioDTO.getCpf())))
                .andExpect(jsonPath("$.telefone", is(funcionarioDTO.getTelefone().toString())))
                .andExpect(jsonPath("$.telefone2", is(funcionarioDTO.getTelefone2())))
                .andExpect(jsonPath("$.telefone3", is(funcionarioDTO.getTelefone3())))
                .andExpect(jsonPath("$.email", is(funcionarioDTO.getEmail())))
                .andExpect(jsonPath("$.loja", is(funcionarioDTO.getLoja().getNomeFantasia())));
    }
}
