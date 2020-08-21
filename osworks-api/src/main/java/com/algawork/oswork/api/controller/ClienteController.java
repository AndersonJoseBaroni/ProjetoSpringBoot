package com.algawork.oswork.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algawork.oswork.domain.model.Cliente;
import com.algawork.oswork.domain.repository.ClienteRepository;
import com.algawork.oswork.domain.services.CadastroClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	@GetMapping("")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	@GetMapping("/{clienteId}")
	// O @PathVariable indica que é para fazer o bind do parametro que esta chegando para variavel
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		 Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		 
		 if(cliente.isPresent()) {
			 return ResponseEntity.ok(cliente.get());
		 }
		 
		 return ResponseEntity.notFound().build();
		 
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)// pode passar aqui ou dentro do metodo
	public Cliente adicionar(@Valid @RequestBody Cliente cliente){
	    return cadastroClienteService.salvar(cliente);	
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(clienteId)) {
        	return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cadastroClienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
	}
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remove(@PathVariable Long clienteId){
        if(!clienteRepository.existsById(clienteId)) {
        	return ResponseEntity.notFound().build();
        }
        cadastroClienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
	}
}
