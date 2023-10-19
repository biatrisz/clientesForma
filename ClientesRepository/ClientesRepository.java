package com.clientes.ClientesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.ClientesEntities.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
