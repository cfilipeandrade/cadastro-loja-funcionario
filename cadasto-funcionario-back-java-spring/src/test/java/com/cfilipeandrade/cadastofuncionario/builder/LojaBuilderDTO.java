package com.cfilipeandrade.cadastofuncionario.builder;

import com.cfilipeandrade.cadastofuncionario.dto.LojaDTO;
import lombok.Builder;

@Builder
public class LojaBuilderDTO {

    @Builder.Default
    private Integer id = 1;

    @Builder.Default
    private String cnpj = "1111.00100.32/765";

    @Builder.Default
    private String nomeFantasia = "Programação";

    @Builder.Default
    private String razaoSocial = "Programação.ltda";

    @Builder.Default
    private String telefone = "8989-8888";

    @Builder.Default
    private Integer numeroDeFuncionarios = 12;

    public LojaDTO toLojaDTO() {
        return new LojaDTO(id,
                cnpj,
                nomeFantasia,
                razaoSocial,
                telefone,
                numeroDeFuncionarios);
    }
}
