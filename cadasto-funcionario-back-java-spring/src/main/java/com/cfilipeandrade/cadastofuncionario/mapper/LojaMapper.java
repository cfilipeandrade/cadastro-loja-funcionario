package com.cfilipeandrade.cadastofuncionario.mapper;

import com.cfilipeandrade.cadastofuncionario.dto.LojaDTO;
import com.cfilipeandrade.cadastofuncionario.model.Loja;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LojaMapper {

    LojaMapper INSTANCE = Mappers.getMapper(LojaMapper.class);

    Loja toModel(LojaDTO lojaDTO);
    
    LojaDTO toDTO(Loja loja);
    
}
