package com.cfilipeandrade.cadastofuncionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioCpfNotFoundException extends Exception{

    public FuncionarioCpfNotFoundException(String cpfFuncionario) {
        super(String.format("Funcionario com o cpf: %s não existe no sistema.", cpfFuncionario));
    }

    
}
