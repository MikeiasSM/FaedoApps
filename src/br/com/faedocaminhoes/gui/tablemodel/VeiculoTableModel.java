/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.gui.tablemodel;

import br.com.faedocaminhoes.model.Fabricante;
import br.com.faedocaminhoes.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Poison
 */
public class VeiculoTableModel extends AbstractTableModel{

    private final List<Veiculo> dados = new ArrayList<>();
    private final String[] colunas = {"Código",
                                      "Modelo",
                                      "Fabricante",
                                      "Cor",
                                      "Placa"};

    
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
                return dados.get(linhaIndex).getModelo();
            case 2:    
                return dados.get(linhaIndex).getProvider();
            case 3:
                return dados.get(linhaIndex).getCor();
            case 4:
                return dados.get(linhaIndex).getPlaca();
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
                dados.get(linhaIndex).setModelo((String) valor);
            case 2:
                dados.get(linhaIndex).setProvider((Fabricante) valor);
            case 3:
                dados.get(linhaIndex).setCor((String) valor);
            case 4:
                dados.get(linhaIndex).setPlaca((String) valor);
            }
    }
    
    public void addRow(Veiculo pVehicle){
        this.dados.add(pVehicle);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableDataChanged();
    }
    
    public void removeAll(){
        this.dados.clear();
        this.fireTableDataChanged();
    }
    
    public Veiculo getObject(int linha){
        Veiculo vehicle = this.dados.get(linha);
        return vehicle;
    }
    
    public List<Veiculo> getList(){
        List<Veiculo> vehicles = this.dados;
        return vehicles;
    }
}
