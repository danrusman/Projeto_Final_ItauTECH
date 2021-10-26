package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.Cliente;
import br.itau.spring04.repository.ClienteRepo;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired // implementa a interface, os métodos, e disponibiliza o objeto para uso
    private ClienteRepo repo;

    /* Recupera informações de um cliente específico */
    @GetMapping("/{codInterno}")
    public ResponseEntity<Cliente> buscaCliente(@PathVariable long codInterno) {
        Cliente cliente = repo.findById(codInterno).orElse(null);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.notFound().build();
    }

    /* Cadastra um novo cliente */
    @PostMapping("/novo")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {

        Cliente clienteNovo = repo.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNovo);
    }

    /* Recupera informações de clientes cadastrados */
    @GetMapping("/listar")
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = repo.findAll();
        return clientes;
    }

     /* Atualiza informações de um cliente específico */
     @PutMapping("/atualizar")
     public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
         long id = cliente.getCodigoInterno();
         if (id == 0) { // não mandou o código do cliente
             return ResponseEntity.badRequest().build();
         }
 
         Cliente clienteEncontrado = repo.findById(id).orElse(null);
         if (clienteEncontrado == null) { // Cliente não encontrada no BD
             return ResponseEntity.badRequest().build(); // 400
         }
 
         Cliente clienteAtualizado = repo.save(cliente);
         return ResponseEntity.ok(clienteAtualizado); // 200
 
     }



}
