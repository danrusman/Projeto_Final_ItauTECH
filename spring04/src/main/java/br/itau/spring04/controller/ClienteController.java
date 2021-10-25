package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/novo")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {

        Cliente clienteNovo = repo.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
    }

    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = repo.findAll();
        return clientes;
    }


}
