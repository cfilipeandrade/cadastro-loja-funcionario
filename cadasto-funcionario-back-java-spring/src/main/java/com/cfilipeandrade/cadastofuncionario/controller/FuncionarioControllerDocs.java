package com.cfilipeandrade.cadastofuncionario.controller;

import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.controller.FuncionarioController;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioCpfNotFoundException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Cadastro de Funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
public interface FuncionarioControllerDocs {


    @ApiOperation(value = "Operação de cadastro")
    @ApiResponses( value = {
            @ApiResponse(code = 201, message = "Cadastro realizado"),
            @ApiResponse(code = 400, message = "Campos obrigatórios ausentes ou valor de intervalo de campo incorreto.")
    })
    FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegisteredException;

    @ApiOperation(value = "Retorna funcionario encontrada por um determinado nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Funcionario encontrado no sistema."),
            @ApiResponse(code = 404, message = "Funcionario com nome fornecido não encontrado.")
    })
    FuncionarioDTO findByNome(@PathVariable String nome) throws FuncionarioNotFoundException ;


    @ApiOperation(value = "Retorna lista de funcionarios registrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de todos os funcionarios registrados no sistema")
    })
    List<FuncionarioDTO> listFuncionario();

    @ApiOperation(value = "Deletar funcionário do sistema pelo cpf")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Funcionario deletado do sistema."),
            @ApiResponse(code = 404, message = "Funcionario não encontrado.")
    })
    void deleteByCpf(@PathVariable String cpf) throws FuncionarioCpfNotFoundException;
}
