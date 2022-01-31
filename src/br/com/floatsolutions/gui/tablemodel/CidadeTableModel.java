/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.tablemodel;

import br.com.floatsolutions.model.Cidade;
import br.com.floatsolutions.model.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class CidadeTableModel extends AbstractTableModel{

    private final List<Cidade> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Cidade", 
                                      "Estado"};

    
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
                return dados.get(linhaIndex).getEstado().getNome();
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
                dados.get(linhaIndex).setEstado((Estado) valor);
            }
    }
    
    public void addRow(Cidade cidade){
        this.dados.add(cidade);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Cidade getObject(int linha){
        Cidade cidade = this.dados.get(linha);
        return cidade;
    }
    
    public List<Cidade> getObject(){
        return this.dados;         
    }
}
