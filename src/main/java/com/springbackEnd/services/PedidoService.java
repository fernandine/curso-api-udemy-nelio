package com.springbackEnd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackEnd.domain.Cliente;
import com.springbackEnd.repositories.ClienteRepository;
import com.springbackEnd.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
		
	}
	

