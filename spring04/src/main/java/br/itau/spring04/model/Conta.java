package br.itau.spring04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //diz que essa classe vai ser armazenada no BD, pois nem todas pode ser armazenadas no BD
@Table(name = "tb_conta") ///JPA sabe qual a tabela no banco que corresponde a essa CLASSE
public class Conta {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 1, 2, 3...
    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "agencia", nullable = false)
    private int agencia;

    @Column(name = "tipo_conta", nullable = false)
    private int tipoConta;

    @Column(name = "saldo",nullable = false)
    private double saldo;

    @Column(name = "titular", nullable = false)
    private String titular;

     //atributo de ligacao com o cliente
     @OneToOne // uma conta relacionada a 1 Cliente 
     @JoinColumn(name = "cod_cliente") // código do cliente que é dono desta conta
     private Cliente titularConta;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Cliente getTitularConta() {
        return titularConta;
    }
    public void setTitularConta(Cliente titularConta) {
        this.titularConta = titularConta;
    }  

    

}
