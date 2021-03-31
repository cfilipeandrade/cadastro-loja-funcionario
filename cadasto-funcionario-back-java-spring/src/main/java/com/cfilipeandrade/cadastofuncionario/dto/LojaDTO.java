package com.cfilipeandrade.cadastofuncionario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaDTO {

    private Integer id;

    @NotNull
    @Size(min = 14)
    private String cnpj;

    @NotNull
    @Size(min = 5, max = 200)
    private String nomeFantasia;

    @NotNull
    @Size(min = 1, max = 200)
    private String razaoSocial;

    @NotNull
    @Size(min = 11)
    private String telefone;

    @NotNull
    @Size(min = 1)
    private Integer numeroDeFuncionarios;
    
}
