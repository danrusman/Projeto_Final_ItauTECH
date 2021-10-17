package br.itau.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Conta>> listarTodosContas(){
        List<Conta> lista = (List<Conta>) repo.findAll(); 

        return ResponseEntity.ok(lista);
    }


    @GetMapping("/contas/{numero}")
	public ResponseEntity<Conta> recuperarPeloNumero(@PathVariable int numero) {
		Conta resultado = repo.findById(numero).orElse(null);

		if (resultado != null) {
			return ResponseEntity.ok(resultado);
		} else {
			return ResponseEntity.notFound().build();
		}
    }
}

