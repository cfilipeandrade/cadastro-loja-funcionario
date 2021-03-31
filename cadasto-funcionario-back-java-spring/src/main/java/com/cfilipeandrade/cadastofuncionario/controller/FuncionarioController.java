package com.cfilipeandrade.cadastofuncionario.controller;

import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioCpfNotFoundException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioNotFoundException;
import com.cfilipeandrade.cadastofuncionario.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioController implements FuncionarioControllerDocs{

    private final FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioDTO createFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegisteredException {
        return funcionarioService.createFuncionario(funcionarioDTO);
    }

    @GetMapping("/{name}")
    public FuncionarioDTO findByNome(@PathVariable String name) throws FuncionarioNotFoundException {
        return funcionarioService.findByNome(name);
    }

    @GetMapping
    public List<FuncionarioDTO> listFuncionario() {

        return funcionarioService.listAll();
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCpf(@PathVariable String cpf) throws FuncionarioCpfNotFoundException {
        funcionarioService.deleteByCpf(cpf);
    }
}
