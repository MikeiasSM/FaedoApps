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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
    @JoinColumn(name = "idProvider")
    private Fabricante provider;
    private String cor;
    private String placa;
    @ManyToMany(mappedBy = "vehicles")
    private List<Pessoa> persons;

    public Veiculo() {
        
    }

    public Veiculo(Integer id, String modelo, Fabricante provider, String cor, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.provider = provider;
        this.cor = cor;
        this.placa = placa;
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
        return persons;
    }

    public void setPersons(List<Pessoa> persons) {
        this.persons = persons;
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
        return this.getId() +" - "+getModelo()+" - "+this.getPlaca()+" - "+getCor();

    }
}
