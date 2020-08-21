package com.algawork.oswork.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algawork.oswork.domain.exception.NegocioException;
import com.algawork.oswork.domain.model.Cliente;
import com.algawork.oswork.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
    
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
		    throw new NegocioException("Já existi um cliente cadastrado com esse email");	
		}
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
		
	}
}
