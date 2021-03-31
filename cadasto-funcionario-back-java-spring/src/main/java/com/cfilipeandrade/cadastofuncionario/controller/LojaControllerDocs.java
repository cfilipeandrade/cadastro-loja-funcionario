package com.cfilipeandrade.cadastofuncionario.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.cfilipeandrade.cadastofuncionario.dto.LojaDTO;
import com.cfilipeandrade.cadastofuncionario.exception.LojaAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.exception.LojaNotFoundException;

@Api("Cadastro de Funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
public class LojaControllerDocs {

    @ApiOperation(value = "Operação de cadastro")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Cadastro realizado"),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes ou valor de intervalo de campo incorreto.")
    })
    LojaDTO createLoja(LojaDTO lojaDTO) throws LojaAlreadyRegisteredException;

    @ApiOperation(value = "Retorna loja encontrada por um determinado nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Loja encontrado no sistema."),
            @ApiResponse(code = 404, message = "Loja com nome fornecido não encontrado.")
    })
    LojaDTO findByNomeFantasia(@PathVariable String nomeFantasia) throws LojaNotFoundException ;


    @ApiOperation(value = "Retorna lista de funcionarios registrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de todos os funcionarios registrados no sistema")
    })
    List<LojaDTO> listLoja();

    
}
