/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mikeias
 */


@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cidade;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name="id_estado", nullable = false)
    private Estado estado;
       
    
    public Cidade(){
        
    }
    
    public Cidade(Integer id_cidade, String nome, Estado estado){
        this.id_cidade = id_cidade;
        this.nome = nome;
        this.estado = estado;
    }

    public Integer getId() {
        return id_cidade;
    }

    public void setId(Integer id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id_cidade);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id_cidade, other.id_cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome()+" - "+getEstado().getNome();
    }
    
}
