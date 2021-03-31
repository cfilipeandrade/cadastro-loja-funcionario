package com.cfilipeandrade.cadastofuncionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FuncionarioAlreadyRegisteredException extends Exception {

    public FuncionarioAlreadyRegisteredException(String nome) {
        super(String.format("Funcionario com o nome %s já cadastrado no sistema.", nome));
    }
    
}
