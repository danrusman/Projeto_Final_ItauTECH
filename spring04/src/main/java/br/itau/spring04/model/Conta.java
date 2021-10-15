package br.itau.spring04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //diz que essa classe vai ser armazenada no BD, pois nem todas pode ser armazenadas no BD
@Table(name = "tb_conta") ///JPA sabe qual a tabela no banco que corresponde a essa CLASSE
public class Conta {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 1, 2, 3...
    @Column(name = "cod")
    private int numero;

    @Column(name = "agencia", unique = true, nullable = false)
    private int agencia;

    @Column(name = "tipo_conta", unique = true, nullable = false)
    private int tipoConta;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "titular", unique = true, nullable = false)
    private String titular;



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

    

}