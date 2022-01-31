/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.tablemodel;

import br.com.floatsolutions.model.Abastecimento;
import br.com.floatsolutions.model.Empresa;
import br.com.floatsolutions.model.Fornecedor;
import br.com.floatsolutions.model.Pessoa;
import br.com.floatsolutions.model.Produto;
import br.com.floatsolutions.model.Usuario;
import br.com.floatsolutions.model.Veiculo;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class AbastecimentoTableModel extends AbstractTableModel{

    private NumberFormat moeda = new DecimalFormat("#,##0.00");
    private final List<Abastecimento> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Fornecedor",
                                      "Pessoa",
                                      "Veiculo", 
                                      "Dta. Abastecimento",
                                      "Combustivel",
                                      "Quantidade", 
                                      "Valor",
                                      "Responsavel", 
                                      "Nº Requisição", 
                                      "Nº Cupom",
                                      "Dta. Alteração",
                                      "Observação",
                                      "Usuário",
                                      "Empresa"};

    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
       return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linhaIndex, int colunaIndex) {
        switch(colunaIndex){
            case 0:
                return dados.get(linhaIndex).getId();
            case 1:
                return dados.get(linhaIndex).getFornecedor().getFantasia();
            case 2:
                return dados.get(linhaIndex).getPessoa().getNome();
            case 3:
                return dados.get(linhaIndex).getVeiculo().getModelo();
            case 4:
                LocalDate d = dados.get(linhaIndex).getData_abastecimento();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return d.format(df);
            case 5:
                return dados.get(linhaIndex).getProduto().getDescricao();
            case 6:
                return dados.get(linhaIndex).getQuantidade();
            case 7:
                return dados.get(linhaIndex).getVlr_total();
            case 8:
                return dados.get(linhaIndex).getResponsavel();
            case 9:
                return dados.get(linhaIndex).getN_requisicao();
            case 10:
                return dados.get(linhaIndex).getN_cupom();
            case 11:
                LocalDateTime dt = dados.get(linhaIndex).getInstante_lancamento();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                return dtf.format(dt);
            case 12:
                return dados.get(linhaIndex).getObservacao();
            case 13:
                return dados.get(linhaIndex).getUsuario().getNome();
            case 14:
                return dados.get(linhaIndex).getEmpresa().getRazao();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int linhaIndex, int coluna) {
        switch(coluna){
            case 0:
                dados.get(linhaIndex).setId((Integer) valor);
            case 1:
                dados.get(linhaIndex).setFornecedor((Fornecedor) valor);
            case 2:
                dados.get(linhaIndex).setData_abastecimento((LocalDate) valor);
            case 3:
                dados.get(linhaIndex).setPessoa((Pessoa) valor);
            case 4:
                dados.get(linhaIndex).setProduto((Produto) valor);
            case 5:
                dados.get(linhaIndex).setVeiculo((Veiculo) valor);
            case 6:
                dados.get(linhaIndex).setQuantidade((BigDecimal) valor);
            case 7:
                dados.get(linhaIndex).setVlr_total((BigDecimal) valor);
            case 8:
                dados.get(linhaIndex).setResponsavel((String) valor);
            case 9:
                dados.get(linhaIndex).setN_requisicao((Integer) valor);
            case 10:
                dados.get(linhaIndex).setN_cupom((Integer) valor);
            case 11:
                dados.get(linhaIndex).setInstante_lancamento((LocalDateTime) valor);
            case 12:
                dados.get(linhaIndex).setObservacao((String) valor);
            case 13:
                dados.get(linhaIndex).setUsuario((Usuario) valor);
            case 14:
                dados.get(linhaIndex).setEmpresa((Empresa) valor);
            }
    }
    
    public void addRow(Abastecimento abastecimento){
        this.dados.add(abastecimento);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Abastecimento getObject(int linha){
        Abastecimento abastecimento = this.dados.get(linha);
        return abastecimento;
    }
    
    public List<Abastecimento> getDados(){
        return  this.dados;
    }
}
