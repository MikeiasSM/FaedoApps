/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.gui.tablemodel;

import br.com.faedocaminhoes.model.CategoriaProd;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class CategoriaTableModel extends AbstractTableModel{

    private final List<CategoriaProd> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Nome", 
                                      "Sigla"};

    
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
                return dados.get(linhaIndex).getSigla();
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
                dados.get(linhaIndex).setSigla((String) valor);
            }
    }
    
    public void addRow(CategoriaProd pCategoriaProd){
        this.dados.add(pCategoriaProd);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public CategoriaProd getObject(int linha){
        CategoriaProd categoria = this.dados.get(linha);
        return categoria;
    }
}
