/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.tablemodel;

import br.com.floatsolutions.model.Fabricante_Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class FabricanteTableModel extends AbstractTableModel{

    private final List<Fabricante_Veiculo> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Nome"};

    
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
                return dados.get(linhaIndex).getDescricao();
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
                dados.get(linhaIndex).setDescricao((String) valor);
            }
    }
    
    public void addRow(Fabricante_Veiculo pProvider){
        this.dados.add(pProvider);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Fabricante_Veiculo getObject(int linha){
        Fabricante_Veiculo provider = this.dados.get(linha);
        return provider;
    }
}
