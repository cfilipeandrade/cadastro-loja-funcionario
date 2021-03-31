package com.cfilipeandrade.cadastofuncionario.builder;

import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.model.Loja;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public class FuncionarioBuilderDTO {

    @Builder.Default
    private String nome = "Carlos Filipe Andrade";

    @Builder.Default
    private String cpf = "333.333.333-63";

    @Builder.Default
    private String telefone = "8888-8888";

    @Builder.Default
    private String telefone2 = "5555-555";

    @Builder.Default
    private String telefone3 = "5555-5544";

    @Builder.Default
    private String email = "cfilipeas06@gmail.com";

    @Builder.Default
    private Loja loja = Loja.builder().build();

    public FuncionarioDTO toFuncionarioDTO() {
        return new FuncionarioDTO(cpf,
                nome,
                telefone,
                telefone2,
                telefone3,
                email,
                loja);
    }

}
