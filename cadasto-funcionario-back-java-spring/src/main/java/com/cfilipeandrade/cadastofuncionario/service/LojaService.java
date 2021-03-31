package com.cfilipeandrade.cadastofuncionario.service;

import java.util.Optional;
import java.util.stream.Collectors;

import com.cfilipeandrade.cadastofuncionario.dto.LojaDTO;
import com.cfilipeandrade.cadastofuncionario.exception.LojaAlreadyRegisteredException;
import com.cfilipeandrade.cadastofuncionario.mapper.LojaMapper;
import com.cfilipeandrade.cadastofuncionario.model.Loja;
import com.cfilipeandrade.cadastofuncionario.repository.LojaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LojaService {

    private LojaRepository lojaRepository;

    private final LojaMapper lojaMapper;

    public LojaDTO createLoja(LojaDTO lojaDTO) throws LojaAlreadyRegisteredException{
        verifyIfLojaIsAlreadyRegistered(lojaDTO.getId());
        Loja loja = lojaMapper.toModel(lojaDTO);
        Loja savedLoja = lojaRepository.save(loja);
        return lojaMapper.toDTO(savedLoja);
    }

    public List<LojaDTO> listAllLojas{
        return lojaRepository.findAll().stream()
        .map(lojaMapper::toDTO)
        .collect(Collectors.toList());
    }

    private void verifyIfLojaIsAlreadyRegistered(String nomeFantasia) throws LojaAlreadyRegisteredException {
        Optional<Loja> optSavedLoja = lojaRepository.findByNomeFantasia(nomeFantasia);
        if (optSavedLoja.isPresent()) {
            throw new LojaAlreadyRegisteredException(nomeFantasia);
        }
    }

    public LojaDTO findByNomeFantasia(String nomeFantasia) throws LojaNotFoundException {
        Loja foundLoja = lojaRepository.findByNomeFantasia(nomeFantasia)
        .orElseThrow(() -> new LojaNotFoundException(nomeFantasia));
        return lojaMapper.toDTO(foundLoja);
    }
    
}
