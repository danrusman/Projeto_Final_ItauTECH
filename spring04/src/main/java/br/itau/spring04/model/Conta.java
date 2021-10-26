package br.itau.spring04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // diz que essa classe vai ser armazenada no BD
@Table(name = "tb_conta") /// JPA sabe qual a tabela no banco que corresponde a essa CLASSE
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 1, 2, 3...
    @Column(name = "numero")
    private long numero;

    @Column(name = "saldo", nullable = false)
    private double saldo; 

    @ManyToOne // Várias contas relacionadas com um cliente
    @JoinColumn(name = "titular", nullable = false) // chave de ligação com a entidade Cliente
    @JsonIgnoreProperties("conta") // Ignore o campo conta
    private Cliente cliente; 

    @ManyToOne   // Várias contas relacionadas com uma agência
    @JoinColumn(name = "cod_agencia", nullable = false) // chave de ligação com a entidade agência
    @JsonIgnoreProperties("conta") // Ignore o campo conta
    private Agencia agencia; // "agencia": {"codigo": 1},

    @ManyToOne // Várias contas relacionadas com um tipo de conta
    @JoinColumn(name = "tipo_conta", nullable = false) // chave de ligação com a entidade TipoConta
    @JsonIgnoreProperties("conta")  // Ignore o campo conta
    private TipoConta tipoConta;

    
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

           
}