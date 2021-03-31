package com.cfilipeandrade.cadastofuncionario.exception;

public class LojaNotFoundException {

    public LojaNotFoundException(String nomeFantasia) {
        super(String.format("Loja com o nome %s não existe no sistema.", nomeFantasia));
    }
    
}
