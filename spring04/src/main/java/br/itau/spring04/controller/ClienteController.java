package br.itau.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.Cliente;
import br.itau.spring04.repository.ClienteRepo;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepo repo;

    @GetMapping("/{codInterno}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable long codInterno) {
        Cliente cliente = repo.findById(codInterno).orElse(null);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.notFound().build();
    }

}
