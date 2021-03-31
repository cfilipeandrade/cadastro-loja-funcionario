package com.cfilipeandrade.cadastofuncionario.dto;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cfilipeandrade.cadastofuncionario.model.Loja;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    @NotNull
    @Size(min = 20, max = 200)
    private String nome;

    @CPF
    @NotNull
    private String cpf;

    @NotNull
    private String telefone;

    private String telefone2;

    private String telefone3;

    @Email
    @NotNull
    private String email;

    private Loja loja;
    
}
