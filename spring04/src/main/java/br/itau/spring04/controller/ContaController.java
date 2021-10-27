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

import br.itau.spring04.model.Conta;
import br.itau.spring04.repository.ContaRepo;

@RestController // indica que esta classe é um controller REST
@CrossOrigin("*") // aceita requisições de outros domínios
@RequestMapping("/") // nome do recurso
public class ContaController {

    @Autowired // implementa a interface, os métodos, e disponibiliza o objeto para uso
    private ContaRepo repo; 

    /* Lista todas as contas com informações dos titulares das contas */
    @GetMapping("/contas") // 1ª maneira de recuperar todos os dados
    public ResponseEntity<List<Conta>> listarTodosContas(){
        List<Conta> lista = (List<Conta>) repo.findAll(); 

        return ResponseEntity.ok(lista);
    }


    @GetMapping("/contas/{id}")
	public ResponseEntity<Conta> recuperarPeloNumero(@PathVariable Long id) {
		Conta resultado = repo.findById(id).orElse(null);

		if (resultado != null) {
			return ResponseEntity.ok(resultado);
		} else {
			return ResponseEntity.notFound().build();
		}
    }

    @PostMapping("/contas/nova")
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta){
        Conta novaConta = repo.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    /* Atualiza informações de uma conta específica */
    @PutMapping("/contas/atualizar")
    public ResponseEntity<Conta> atualizar(@RequestBody Conta conta) {
        long id = conta.getNumero();
        if (id == 0) { // não mandou o código da conta
            return ResponseEntity.badRequest().build();
        }

        Conta contaEncontrada = repo.findById(id).orElse(null);
        if (contaEncontrada == null) { // Conta não encontrada no BD
            return ResponseEntity.badRequest().build(); // 400
        }

        Conta contaAtualizada = repo.save(conta);
        return ResponseEntity.ok(contaAtualizada); // 200

    }
}

