package br.itau.spring04.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.spring04.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Long>{
    public List<Conta> findAll();
}
