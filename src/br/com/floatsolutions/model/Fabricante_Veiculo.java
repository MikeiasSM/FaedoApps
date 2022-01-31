/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Poison
 */
@Entity
public class Fabricante_Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_fabricante;
    private String descricao;
    
    public Fabricante_Veiculo(){
        
    }
    
    public Fabricante_Veiculo(Integer id_fabricante, String descricao){
        this.id_fabricante = id_fabricante;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id_fabricante;
    }

    public void setId(Integer id_fabricante) {
        this.id_fabricante= id_fabricante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Fabricante_Veiculo other = (Fabricante_Veiculo) obj;
        if (!Objects.equals(this.id_fabricante, other.id_fabricante)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getDescricao();
    }
   
}
