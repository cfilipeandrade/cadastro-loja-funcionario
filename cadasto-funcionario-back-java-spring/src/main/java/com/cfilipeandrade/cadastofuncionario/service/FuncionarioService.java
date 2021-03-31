package com.cfilipeandrade.cadastofuncionario.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioCpfNotFoundException;
import com.cfilipeandrade.cadastofuncionario.exception.FuncionarioNotFoundException;
import com.cfilipeandrade.cadastofuncionario.mapper.FuncionarioMapper;
import com.cfilipeandrade.cadastofuncionario.model.Funcionario;
import com.cfilipeandrade.cadastofuncionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioAlreadyRegisteredException{
        verifyIfIsAlreadyRegistered(funcionarioDTO.getNome());
        Funcionario funcionario = funcionarioMapper.toModel(funcionarioDTO);
        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDTO(savedFuncionario);
    }

    public List<FuncionarioDTO> listAll{
        return funcionarioRepository.findAll().stream()
        .map(funcionarioMapper::toDTO)
        .collect(Collectors.toList());
    }

    private void verifyIfIsAlreadyRegistered(String nome) throws FuncionarioAlreadyRegisteredException {
        Optional<Funcionario> optSavedFuncionario = funcionarioRepository.findByNome(nome);
        if (optSavedFuncionario.isPresent()) {
            throw new FuncionarioAlreadyRegisteredException(nome);
        }
    }

    public FuncionarioDTO findByNome(String nome) throws FuncionarioNotFoundException {
        Funcionario foundFuncionario = funcionarioRepository.findByNome(nome)
        .orElseThrow(() -> new FuncionarioNotFoundException(nome));
        return funcionarioMapper.toDTO(foundFuncionario);
    }

    public List<FuncionarioDTO> listAll() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteByCpf(String cpf) throws FuncionarioCpfNotFoundException {
        verifyIfExists(cpf);
        funcionarioRepository.deleteByCpf(cpf);
    }

    private Funcionario verifyIfExists(String cpf) throws FuncionarioCpfNotFoundException {
        return funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new FuncionarioCpfNotFoundException(cpf));
    }

    

}
