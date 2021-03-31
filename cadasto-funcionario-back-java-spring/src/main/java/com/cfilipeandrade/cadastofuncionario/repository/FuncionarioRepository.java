package com.cfilipeandrade.cadastofuncionario.repository;

import java.util.Optional;

import com.cfilipeandrade.cadastofuncionario.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNome(String nome);

    Optional<Funcionario> findByCpf(String cpf);

    void deleteByCpf(String cpf);
    
}
