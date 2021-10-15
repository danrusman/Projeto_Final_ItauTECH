package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.Conta;
import br.itau.spring04.repository.ContaRepo;

@RestController // indica que esta classe é um controller REST
@CrossOrigin("*") // aceita requisições de outros domínios
@RequestMapping("/") // nome do recurso
public class ContaController {

    @Autowired
    private ContaRepo repo; // implementa a interface, os métodos, e disponibiliza o objeto para uso

    @GetMapping("/contas") // 1ª maneira de recuperar todos os dados
    public List<Conta> listarContas(){
        
       return repo.findAll();
    }
}

