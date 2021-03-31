package com.cfilipeandrade.cadastofuncionario.repository;

import java.util.Optional;

import com.cfilipeandrade.cadastofuncionario.model.Loja;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    
    Optional<Loja> findByNomeFantasia(String nomeFantasia);
}
