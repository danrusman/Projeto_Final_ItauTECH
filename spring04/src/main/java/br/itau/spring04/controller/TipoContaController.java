package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itau.spring04.model.TipoConta;
import br.itau.spring04.repository.TipoContaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class TipoContaController {
 
    @Autowired // implementa a interface, os métodos, e disponibiliza o objeto para uso
    private TipoContaRepo repo; 

    /* Retorna todos os tipos de conta */
    @GetMapping("/tipos-contas")
    public List<TipoConta> listar() {
        List<TipoConta> listaTipo = repo.findAll();
        return listaTipo;
    }
   

    /* Atualiza informações de um cliente específico */
    @PutMapping("/atualizar")
    public ResponseEntity<TipoConta> atualizar(@RequestBody TipoConta tipoConta){
        long id = tipoConta.getCodigo();
        if (id == 0) { // não mandou o id da conta
            return ResponseEntity.badRequest().build();
        }

        TipoConta tipoEncontrado = repo.findById(id).orElse(null);
        if (tipoEncontrado == null) { // Tipo não encontrada no BD
            return ResponseEntity.badRequest().build(); // 400
        }

        TipoConta tipoAtualizado = repo.save(tipoConta);
        return ResponseEntity.ok(tipoAtualizado); // 200
    }
}
