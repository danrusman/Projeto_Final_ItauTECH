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

import br.itau.spring04.model.Agencia;
import br.itau.spring04.repository.AgenciaRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class AgenciaController {

    @Autowired
    private AgenciaRepo repo;

    /* Recupera os registros das agências */
    @GetMapping("/agencias")
    public List<Agencia> listar() {
        List<Agencia> agencias = repo.findAll();
        return agencias;
    }

    /* Recupera informações de uma agência específica */
    @GetMapping("/agencias/{id}")
    public ResponseEntity<Agencia> buscarAgencia(@PathVariable long id){
        Agencia resultado = repo.findById(id).orElse(null);

        if (resultado != null) {
            return ResponseEntity.ok(resultado); // 200
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 400
    }

    /* Atualiza informações de uma agência específica */
    @PutMapping("/agencias/atualizar")
    public ResponseEntity<Agencia> atualizar(@RequestBody Agencia agencia) {
        long id = agencia.getCodigo();
        if (id == 0) { // não mandou o código da Agência
            return ResponseEntity.badRequest().build();
        }

        Agencia agenciaEncontrada = repo.findById(id).orElse(null);
        if (agenciaEncontrada == null) { // Agência não encontrada no BD
            return ResponseEntity.badRequest().build(); // 400
        }

        Agencia agenciaAtualizada = repo.save(agencia);
        return ResponseEntity.ok(agenciaAtualizada); // 200

    }

    /* Cria o registro de uma nova agência */
    @PostMapping("/agencias/nova")
    public ResponseEntity<Agencia> novaAgencia(@RequestBody Agencia agencia){
                
        Agencia novaAgencia = repo.save(agencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAgencia); // 201
    }
}
