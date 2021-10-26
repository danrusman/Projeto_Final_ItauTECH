package br.itau.spring04.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.itau.spring04.model.TipoConta;

public interface TipoContaRepo extends CrudRepository<TipoConta, Long>{
    public List<TipoConta> findAll();
    
} 
