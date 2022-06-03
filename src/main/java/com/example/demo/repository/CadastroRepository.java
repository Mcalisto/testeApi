package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer>{
	
	@Query("FROM Cadastro WHERE cpf = ?1")
    public Cadastro findByCpf(String string);
	
	

}
