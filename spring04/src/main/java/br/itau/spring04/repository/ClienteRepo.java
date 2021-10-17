package br.itau.spring04.repository;

import org.springframework.data.repository.CrudRepository;

import br.itau.spring04.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long> {

}
