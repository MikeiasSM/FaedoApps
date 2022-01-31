/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.gui.tablemodel;

import br.com.floatsolutions.model.Categoria_Produto;
import br.com.floatsolutions.model.Produto;
import br.com.floatsolutions.model.Usuario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class ProdutoTableModel extends AbstractTableModel{

    private final List<Produto> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Nome", 
                                      "Categoria",
                                      "Valor", 
                                      "Usr. Cadastro"};

    
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
            case 2:
                return dados.get(linhaIndex).getCategoria().getDescricao();
            case 3:
                return dados.get(linhaIndex).getValor();
            case 4:
                return dados.get(linhaIndex).getUsuario();
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
            case 2:
                dados.get(linhaIndex).setCategoria((Categoria_Produto) valor);
            case 3:
                dados.get(linhaIndex).setValor((BigDecimal) valor);
            case 4:
                dados.get(linhaIndex).setUsuario((Usuario) valor);
            }
    }
    
    public void addRow(Produto pCombustivel){
        this.dados.add(pCombustivel);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Produto getObject(int linha){
        Produto combustivel = this.dados.get(linha);
        return combustivel;
    }
    
}
