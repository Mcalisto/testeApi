package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cadastro;
import com.example.demo.repository.CadastroRepository;


@Controller
@RequestMapping(path = "/cadastro")
public class CadastroController {
    
	@Autowired
	private CadastroRepository cadastroRepository;
	
	public CadastroController (CadastroRepository cadastroRepository) {
		this.cadastroRepository = cadastroRepository;
	}
	
	@PostMapping
	public ResponseEntity<Cadastro> save(@Valid @RequestBody Cadastro cadastro){
		cadastroRepository.save(cadastro);
		return new ResponseEntity<>(cadastro, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cadastro>> getAll(){
		List<Cadastro> cadastro = new ArrayList<>();
		cadastro = cadastroRepository.findAll();
		return new ResponseEntity<>(cadastro, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Cadastro>> getById(@PathVariable Integer id){
		Optional<Cadastro> cadastro;
		try {
			cadastro = cadastroRepository.findById(id);
			return new ResponseEntity<Optional<Cadastro>>(cadastro, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Optional<Cadastro>> deleteById(@PathVariable Integer id){
		try {
			cadastroRepository.deleteById(id);
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cadastro> update(@PathVariable Integer id, @RequestBody Cadastro newCadastro){
		return cadastroRepository.findById(id)
				.map(
				cadastro -> {
				cadastro.setNome(newCadastro.getNome());
				Cadastro cadastrooUpdate = cadastroRepository.save(cadastro);
				return ResponseEntity.ok().body(cadastrooUpdate);
				}
				).orElse(ResponseEntity.notFound().build());
	}
}
