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

    @Column(name = "agencia", nullable = false)
    private int agencia;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(nullable = false)
    private int tipoConta; // 0 - conta corrente, 1 - poupança, 2 - investimento

    // atributo de ligacao com o cliente
    @ManyToOne // uma conta relacionada a 1 Cliente
    @JoinColumn(name = "titular") // código do cliente que é dono desta conta
    @JsonIgnoreProperties("conta")
    private Cliente cliente;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

       
}