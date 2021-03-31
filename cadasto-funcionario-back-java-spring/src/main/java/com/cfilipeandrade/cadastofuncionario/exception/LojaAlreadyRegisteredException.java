package com.cfilipeandrade.cadastofuncionario.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LojaAlreadyRegisteredException {

    public LojaAlreadyRegisteredException(String lojaNome) {
        super(String.format("Loja com o nome %s já cadastrado no sistema.", lojaNome));
    }
    
}
