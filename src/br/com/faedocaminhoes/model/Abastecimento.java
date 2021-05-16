/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Poison
 */
@Entity
public class Abastecimento implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data_abastecimento;
    private LocalDateTime instante_lancamento;
    @ManyToOne
    @JoinColumn(name = "idFornecedor", nullable = false)
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private Produto produto;
    private BigDecimal quantidade;
    private Integer n_requisicao;
    private Integer n_cupom;
    private BigDecimal vlr_unitario;
    private BigDecimal vlr_total;
    @ManyToOne
    @JoinColumn(name = "idPessoa", nullable = false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "idVeiculo", nullable = false)
    private Veiculo veiculo;
    private String responsavel;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    
    public Abastecimento(){
        
    }

    public Abastecimento(Integer id, LocalDate data_abastecimento, LocalDateTime instante_lancamento, Fornecedor fornecedor, Produto produto, BigDecimal quantidade, Integer n_requisicao, Integer n_cupom, BigDecimal vlr_unitario, BigDecimal vlr_total, Pessoa pessoa, Veiculo veiculo, String responsavel, Usuario usuario) {
        this.id = id;
        this.data_abastecimento = data_abastecimento;
        this.instante_lancamento = instante_lancamento;
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.quantidade = quantidade;
        this.n_requisicao = n_requisicao;
        this.n_cupom = n_cupom;
        this.vlr_unitario = vlr_unitario;
        this.vlr_total = vlr_total;
        this.pessoa = pessoa;
        this.veiculo = veiculo;
        this.responsavel = responsavel;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData_abastecimento() {
        return data_abastecimento;
    }

    public void setData_abastecimento(LocalDate data_abastecimento) {
        this.data_abastecimento = data_abastecimento;
    }

    public LocalDateTime getInstante_lancamento() {
        return instante_lancamento;
    }

    public void setInstante_lancamento(LocalDateTime instante_lancamento) {
        this.instante_lancamento = instante_lancamento;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getN_requisicao() {
        return n_requisicao;
    }

    public void setN_requisicao(Integer n_requisicao) {
        this.n_requisicao = n_requisicao;
    }

    public Integer getN_cupom() {
        return n_cupom;
    }

    public void setN_cupom(Integer n_cupom) {
        this.n_cupom = n_cupom;
    }

    public BigDecimal getVlr_unitario() {
        return vlr_unitario;
    }

    public void setVlr_unitario(BigDecimal vlr_unitario) {
        this.vlr_unitario = vlr_unitario;
    }

    public BigDecimal getVlr_total() {
        return vlr_total;
    }

    public void setVlr_total(BigDecimal vlr_total) {
        this.vlr_total = vlr_total;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
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
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Abastecimento other = (Abastecimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId()+" - "+getFornecedor().getRazao();
    }
}
