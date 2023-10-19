	package com.clientes.ClientesService;
	
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientes.ClientesEntities.Clientes;
import com.clientes.ClientesRepository.ClientesRepository;

import jakarta.validation.Valid;
	
		@Service
		public class ClientesService {
			private ClientesRepository clientesRepository;
	
			@Autowired
			public ClientesService(ClientesRepository clientesRepository) {
				this.clientesRepository = clientesRepository;
			}
			public List<Clientes> buscaTodosClientes(){
				return clientesRepository.findAll();
			}
			public Clientes buscaClientesId(Long id) {
				Optional <Clientes> Clientes = clientesRepository.findById(id);
				return Clientes.orElse(null);
			}
			public Clientes salvaClientes(@RequestBody @Valid Clientes Clientes) {
				return clientesRepository.save(Clientes);
			}
			public Clientes alterarClientes(@org.springframework.web.bind.annotation.PathVariable Long id,@RequestBody @Valid Clientes alterarU) {
				Optional <Clientes> existeClientes = clientesRepository.findById(id);
				if (existeClientes.isPresent()) {
					alterarU.setId(id);
					return clientesRepository.save(alterarU);
				}
				return null;
			}
			public boolean apagarClientes(Long Id) {
				Optional <Clientes> existeClientes = clientesRepository.findById(Id);
				if (existeClientes.isPresent()) {
					clientesRepository.deleteById(Id);
					return true;
				}
				return false;
			}
		}
	
	
