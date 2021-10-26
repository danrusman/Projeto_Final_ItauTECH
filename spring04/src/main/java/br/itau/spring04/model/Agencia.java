package br.itau.spring04.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* 
    @Entity 
    Anotação utilizada para informar que uma classe também é uma entidade
    a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados, 
    onde os dados de objetos desse tipo poderão ser persistidos.
    Cada instância dessa entidade representa uma linha dessa tabela.
*/
@Entity
@Table(name = "tb_agencia") // sobrescrevo o nome da classe
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 1, 2, 3...
    @Column(name = "codigo")
    private Long codigo; 

    @Column(name = "cep", length = 10, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;

    @Column(name = "bairro", length = 60, nullable = false)
    private String bairro;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    /*
     * @OneToMany Define uma associação de muitos valores com multiplicidade de um
     * para muitos.
     * 
     * mappedBy O campo que possui o relacionamento. 
     */
    @OneToMany(mappedBy = "agencia") // Uma agência está relacionada com mais de uma conta
    @JsonIgnoreProperties("agencia") // Ignore o campo agencia
    private List<Conta> conta;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Conta> getConta() {
        return conta;
    }

    public void setConta(List<Conta> conta) {
        this.conta = conta;
    }

    

}

