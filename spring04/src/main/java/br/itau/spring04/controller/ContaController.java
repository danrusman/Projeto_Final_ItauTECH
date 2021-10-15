package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.Conta;
import br.itau.spring04.repository.ContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class ContaController {
    
    @Autowired // injeção de dependência
    private ContaRepo repo;

    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> listarContas() {
        List<Conta> contas = (List<Conta>) repo.findAll();

        return ResponseEntity.ok(contas);
    }
}
