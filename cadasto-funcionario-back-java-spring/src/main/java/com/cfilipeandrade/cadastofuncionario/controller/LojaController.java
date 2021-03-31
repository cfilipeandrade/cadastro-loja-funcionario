package com.cfilipeandrade.cadastofuncionario.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.cfilipeandrade.cadastofuncionario.dto.LojaDTO;
import com.cfilipeandrade.cadastofuncionario.exception.LojaAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.exception.LojaNotFoundException;
import com.cfilipeandrade.cadastofuncionario.service.LojaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionarios")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LojaController {

    private final LojaService LojaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LojaDTO createLoja(@RequestBody @Valid LojaDTO lojaDTO) throws LojaAlreadyRegisteredException {
        return LojaService.createLoja(lojaDTO);
    }

    @GetMapping("/{name}")
    public LojaDTO findByNomeFantasia(@PathVariable String nomeFantasia) throws LojaNotFoundException {
        return LojaService.findByNomeFantasia(nomeFantasia);
    }

    @GetMapping
    public List<LojaDTO> lisLojas() {

        return lojaService.listAllLojas();
    }
    
}
