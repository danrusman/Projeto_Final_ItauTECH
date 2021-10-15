package br.itau.spring04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_interno")
    private long codigoInterno;

    @Column(name = "nome", length = 220, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 20, unique = true, nullable = false)
    private String cpf;

    @Column(name = "telefone", length = 30, nullable = false)
    private String telefone;

    @Column(name = "email", length = 30, unique = true, nullable = false)
    private String email;

    
    public long getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(long codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
