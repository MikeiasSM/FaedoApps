/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veiculo;
    private String modelo;
    
    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    private Fabricante_Veiculo fabricante;
    private String cor;
    private String placa;
    
    @ManyToMany(mappedBy = "veiculos", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Pessoa> pessoas;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario;
        
    @OneToMany(mappedBy = "veiculo", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Abastecimento> abastecimentos;

    public Veiculo() {
        
    }

    public Veiculo(Integer id_veiculo, String modelo, Fabricante_Veiculo fabricante, String cor, String placa, List<Pessoa> pessoas, Usuario usuario, List<Abastecimento> abastecimentos) {
        this.id_veiculo = id_veiculo;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.placa = placa;
        this.pessoas = pessoas;
        this.usuario = usuario;
        this.abastecimentos = abastecimentos;
    }

    public Integer getId() {
        return id_veiculo;
    }

    public void setId(Integer id) {
        this.id_veiculo = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Fabricante_Veiculo getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante_Veiculo fabricante) {
        this.fabricante = fabricante;
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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id_veiculo);
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
        if (!Objects.equals(this.id_veiculo, other.id_veiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getPlaca()+" - "+getFabricante().getDescricao()+" - "+getModelo()+" - "+getCor();

    }
}
