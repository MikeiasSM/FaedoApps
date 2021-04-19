/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.gui.tablemodel;

import br.com.faedocaminhoes.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class PessoaTableModel extends AbstractTableModel{

    private final List<Pessoa> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Nome",
                                      "CPF/CNPJ",
                                      "Telefone",
                                      "E-mail"};

    
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
                return dados.get(linhaIndex).getNome();
            case 2:
                return dados.get(linhaIndex).getCpf_cnpj();
            case 3:
                return dados.get(linhaIndex).getTelefone();
            case 4:
                return dados.get(linhaIndex).getEmail();
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
                dados.get(linhaIndex).setNome((String) valor);
            case 2:
                dados.get(linhaIndex).setCpf_cnpj((String) valor);
            case 3:
                dados.get(linhaIndex).setTelefone((String) valor);
            case 4:
                dados.get(linhaIndex).setEmail((String) valor);
            }
    }
    
    public void addRow(Pessoa pPessoa){
        this.dados.add(pPessoa);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Pessoa getObject(int linha){
        Pessoa pessoa = this.dados.get(linha);
        return pessoa;
    }
}
