package br.itau.spring04.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.spring04.model.Agencia;

public interface AgenciaRepo extends CrudRepository<Agencia, Long>{
    public List<Agencia> findAll();
    
} 
