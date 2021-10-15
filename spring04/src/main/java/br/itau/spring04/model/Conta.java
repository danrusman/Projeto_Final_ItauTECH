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
    private int codConta;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "agencia", nullable = false)
    private int agencia;

    @Column(name = "tipo_conta", nullable = false)
    private int tipoConta;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "titular", nullable = false)
    private String titular;


    public int getCodConta() {
        return codConta;
    }

    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }

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
