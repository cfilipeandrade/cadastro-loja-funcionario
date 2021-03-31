package com.cfilipeandrade.cadastofuncionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @NotNull
    @Column(nullable = false)
    private String nome;

    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;

    private String telefone2;

    private String telefone3;

    @Email
    @Column(nullable = false)
    private String email;

    @JoinColumn(name = "id_loja")
    private Loja loja;



    
    

    /**- Funcionario:
* Nome: String
* CPF: String com validador
* Telefone: 1 ou mais
* Email: String
 */
 
}
