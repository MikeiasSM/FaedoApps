/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model;

import br.com.floatsolutions.model.enumerado.TipoPessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Poison
 */
@Entity
public class Pessoa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;
    private String nome;
    private String cpf_cnpj;
    private String telefone;
    private String email;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veiculo")
    private List<Veiculo> veiculos;
    
    @OneToMany(mappedBy = "pessoa")
    private List<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();
    private Integer tipo_pessoa;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario;
    
    
    public Pessoa(){
        
    }

    public Pessoa(Integer id_pessoa, String nome, String cpf_cnpj, String telefone, String email, List<Veiculo> veiculos, List<Abastecimento> abastecimentos, Integer tipo_pessoa, Usuario usuario) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.telefone = telefone;
        this.email = email;
        this.veiculos = veiculos;
        this.abastecimentos = abastecimentos;
        this.tipo_pessoa = tipo_pessoa;
        this.usuario = usuario;
    }
    
    public Integer getId() {
        return id_pessoa;
    }

    public void setId(Integer id) {
        this.id_pessoa = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
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

    public TipoPessoa getTipo_pessoa() {
        return TipoPessoa.toEnum(tipo_pessoa);
    }

    public void setTipo_pessoa(TipoPessoa tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa.getCod();
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id_pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id_pessoa, other.id_pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
    /*
     *   
     */
}
