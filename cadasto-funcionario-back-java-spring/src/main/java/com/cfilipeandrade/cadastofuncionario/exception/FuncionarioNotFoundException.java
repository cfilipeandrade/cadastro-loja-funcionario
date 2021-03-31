package com.cfilipeandrade.cadastofuncionario.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Exception{

    public FuncionarioNotFoundException(String nomeFuncionario) {
        super(String.format("Funcionario com o nome %s não existe no sistema.", nomeFuncionario));
    }

}

