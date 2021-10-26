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
@Table(name = "tb_tipo_conta") // sobrescrevo o nome da classe
public class TipoConta {

    /*
     * @GeneratedValue é utilizada para informar que a geração do valor do
     * identificador único da entidade será gerenciada pelo provedor de
     * persistência.
     * 
     * strategy Modificamos a estratégia de geração da chave primária
     * 
     * GenerationType.IDENTITY Informamos ao provedor de persistência que os valores
     * a serem atribuídos ao identificador único serão gerados pela coluna de auto
     * incremento do banco de dados
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment 1, 2, 3...
    @Column(name = "codigo")
    private long codigo;

    @Column(name = "numero", nullable = false, unique = true)
    private int numero;

    @Column(name = "descricao", length = 20, nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "tipoConta")  // um tipo de conta está relacionado a mais de uma conta
    @JsonIgnoreProperties("tipoConta")  // Ignore o campo agencia
    private List<Conta> conta;


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Conta> getConta() {
        return conta;
    }

    public void setConta(List<Conta> conta) {
        this.conta = conta;
    }  
    

    

}
