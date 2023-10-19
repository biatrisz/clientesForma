package com.clientes.CilentesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientes.ClientesEntities.Clientes;
import com.clientes.ClientesService.ClientesService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


public class ClientesController {
	private ClientesService clientesService;
	
	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Clientes> buscaClientesControlId(@PathVariable Long id){
		Clientes clientes = clientesService.buscaClientesId(id);
		if (clientes != null) {
			return ResponseEntity.ok(clientes);
		}
		else {
			return ResponseEntity.notFound().build();		
		}

	}
	@GetMapping("/")
	@Operation 
	public ResponseEntity<List<Clientes>>buscaTodosClientesControl(){
		List <Clientes> Clientes = clientesService.buscaTodosClientes();
		return ResponseEntity.ok(Clientes);
	}
	@PostMapping("/")
	@Operation 
	public ResponseEntity<Clientes> salvaClientesControl(@RequestBody @Valid Clientes clientes){
		Clientes salvaClientes = clientesService.salvaClientes(clientes);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaClientes);
	}
		@PutMapping("/{id}")
		public ResponseEntity<Clientes> alteraClientesControl(@PathVariable Long id, @RequestBody @Valid Clientes clientes){
			Clientes alteraClientes = clientesService.alterarClientes(id, clientes);
			if(alteraClientes != null) {
				return ResponseEntity.ok(clientes);
			}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	@DeleteMapping("/{id}")
	@Operation 
	public ResponseEntity<Clientes> apagaClientesControl(@PathVariable  Long id){
		boolean apagar = clientesService.apagarClientes(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
