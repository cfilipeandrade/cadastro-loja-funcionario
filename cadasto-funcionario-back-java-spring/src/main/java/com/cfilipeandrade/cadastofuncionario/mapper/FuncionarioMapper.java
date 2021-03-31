package com.cfilipeandrade.cadastofuncionario.mapper;

import com.cfilipeandrade.cadastofuncionario.dto.FuncionarioDTO;
import com.cfilipeandrade.cadastofuncionario.model.Funcionario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionarioMapper {

    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario toModel(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO toDTO(Funcionario funcionario);

}
