/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Poison
 */
@Entity
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "idProvider", nullable = false)
    private Fabricante provider;
    private String cor;
    private String placa;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pessoa_veiculo", 
            joinColumns = @JoinColumn(name = "veiculo_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "pessoa_id", nullable = false), 
            foreignKey = @ForeignKey(name = "fk_veiculo_id"),
            inverseForeignKey = @ForeignKey(name = "fk_pessoa_id"))
    private List<Pessoa> pessoas;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "veiculo")
    private List<Abastecimento> abastecimentos;

    public Veiculo() {
        
    }

    public Veiculo(Integer id, String modelo, Fabricante provider, String cor, String placa, Usuario usuario) {
        this.id = id;
        this.modelo = modelo;
        this.provider = provider;
        this.cor = cor;
        this.placa = placa;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Fabricante getProvider() {
        return provider;
    }

    public void setProvider(Fabricante provider) {
        this.provider = provider;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Pessoa> getPersons() {
        return pessoas;
    }

    public void setPersons(List<Pessoa> pessoa) {
        this.pessoas = pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getPlaca()+" - "+getProvider().getNome()+" - "+getModelo()+" - "+getCor();

    }
}
